import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

@SuppressWarnings("serial")
public class SwingExecutorCompletionService extends JPanel {
   public static final int MYTHREADS = 10;
   private static final int LIST_PROTOTYPE_SIZE = 120;
   private static final String LIST_PROTOTYPE_STRING = "%" + LIST_PROTOTYPE_SIZE + "s";
   public static final String[] HOST_LIST = { 
      "http://crunchify.com",
      "http://yahoo.com", 
      "http://www.ebay.com", 
      "http://google.com",
      "http://www.example.co", 
      "https://paypal.com", 
      "http://bing.com/",
      "http://techcrunch.com/", 
      "http://mashable.com/",
      "http://thenextweb.com/", 
      "http://wordpress.com/",
      "http://wordpress.org/", 
      "http://example.com/", 
      "http://sjsu.edu/",
      "http://ebay.co.uk/", 
      "http://google.co.uk/",
      "http://www.wikipedia.org/", 
      "http://en.wikipedia.org/wiki/Main_Page" };

   private JProgressBar pbarStatus = new JProgressBar(0, 100);
   private JButton doItButton = new JButton(new DoItAction("Do It", KeyEvent.VK_D));
   private DefaultListModel<String> listModel = new DefaultListModel<>();
   private JList<String> resultList = new JList<>(listModel);

   public SwingExecutorCompletionService() {
      resultList.setVisibleRowCount(10);
      resultList.setPrototypeCellValue(String.format(LIST_PROTOTYPE_STRING, ""));
      resultList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

      add(pbarStatus);
      add(doItButton);
      add(new JScrollPane(resultList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
   }

   public void addToCompletionList(String element) {
      listModel.addElement(element);
   }

   public void setStatusValue(int progress) {
      pbarStatus.setValue(progress);
   }

   class DoItAction extends AbstractAction {
      public DoItAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         setEnabled(false);
         DoItWorker worker = new DoItWorker(HOST_LIST, MYTHREADS);
         SwingExecutorCompletionService gui = SwingExecutorCompletionService.this;
         PropertyChangeListener workerListener = new WorkerChangeListener(gui, this);
         worker.addPropertyChangeListener(workerListener);
         worker.execute();
      }
   }

   private static void createAndShowGui() {
      SwingExecutorCompletionService mainPanel = new SwingExecutorCompletionService();

      JFrame frame = new JFrame("Swing ExecutorCompletionService");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class MyCallable implements Callable<String> {
   private static final String RED = "->Red<-";
   private static final String GREEN = "Green";
   private final String url;
   private volatile boolean flgStop;

   MyCallable(String url) {
      this.url = url;
   }

   @Override
   public String call() throws Exception {
      String result = "";
      int code = HttpURLConnection.HTTP_OK;
      try {
         // if(flgStop == true)
         if (flgStop) {
            // Stop thread execution
         }
         URL siteURL = new URL(url);
         HttpURLConnection connection = (HttpURLConnection) siteURL
               .openConnection();
         connection.setRequestMethod("GET");
         connection.connect();

         code = connection.getResponseCode();

         // No don't set the prog bar in a background thread!
         // !! pbarStatus.setValue(pbarStatus.getValue()+1); 
         // avoid magic numbers
         if (code == HttpURLConnection.HTTP_OK) {
            result = GREEN;
         }
      } catch (Exception e) {
         result = RED;
      }
      return String.format("%-40s %s", url + ":", result);
   }

}

class WorkerChangeListener implements PropertyChangeListener {
   private Action action;
   private SwingExecutorCompletionService gui;

   public WorkerChangeListener(SwingExecutorCompletionService gui, Action button) {
      this.gui = gui;
      this.action = button;
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      DoItWorker worker = (DoItWorker)evt.getSource();
      if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
         action.setEnabled(true);
         try {
            worker.get();
         } catch (InterruptedException e) {
            e.printStackTrace();
         } catch (ExecutionException e) {
            e.printStackTrace();
         }
      } else if (DoItWorker.INTERMEDIATE_RESULT.equals(evt.getPropertyName())) {
         gui.addToCompletionList(evt.getNewValue().toString());
      } else if ("progress".equals(evt.getPropertyName())) {
         gui.setStatusValue(worker.getProgress());
      }
   }
}

class DoItWorker extends SwingWorker<Void, String> {
   public static final String INTERMEDIATE_RESULT = "intermediate result";
   private static final long TIME_OUT = 5;
   private static final TimeUnit UNIT = TimeUnit.MINUTES;

   private String intermediateResult;
   private ExecutorService executor;
   private CompletionService<String> completionService;
   private String[] hostList;

   public DoItWorker(String[] hostList, int myThreads) {
      this.hostList = hostList;
      executor = Executors.newFixedThreadPool(myThreads);
      completionService = new ExecutorCompletionService<>(executor);
   }

   @Override
   protected Void doInBackground() throws Exception {
      for (int i = 0; i < hostList.length; i++) {

         String url = hostList[i];
         Callable<String> callable = new MyCallable(url);
         completionService.submit(callable);
      }
      executor.shutdown();
      for (int i = 0; i < hostList.length; i++) {
         String result = completionService.take().get();
         publish(result);
         int progress = (100 * i) / hostList.length;
         setProgress(progress);
      }
      executor.awaitTermination(TIME_OUT, UNIT);
      setProgress(100);
      return null;
   }

   @Override
   protected void process(List<String> chunks) {
      for (String chunk : chunks) {
         setIntermediateResult(chunk);
      }
   }

   private void setIntermediateResult(String intermediateResult) {
      String oldValue = this.intermediateResult;
      String newValue = intermediateResult;
      this.intermediateResult = intermediateResult;
      firePropertyChange(INTERMEDIATE_RESULT, oldValue, newValue);
   }

}