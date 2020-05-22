import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.swing.*;

public class ShowTextControl {

   private MvcView view;
   private MvcModel model;

   public ShowTextControl(MvcView view, MvcModel model) {
      this.view = view;
      this.model = model;

      view.setFileAction(new FileAction("File", KeyEvent.VK_F));
      view.setOpenFileAction(new OpenFileAction(view, model, "Open File",
            KeyEvent.VK_O));
      view.setSaveToFileAction(new SaveToFileAction(view, model,
            "Save to File", KeyEvent.VK_S));
      view.setExitAction(new ExitAction(view, model, "Exit", KeyEvent.VK_X));

      model.addPropertyChangeListener(new ModelListener(view, model));
   }

   public void showView(boolean visible) {
      view.setVisible(visible);
   }
}

@SuppressWarnings("serial")
class OpenFileAction extends AbstractAction {
   private MvcView view;
   private MvcModel model;

   public OpenFileAction(MvcView view, MvcModel model, String name, int keyCode) {
      super(name);
      putValue(MNEMONIC_KEY, keyCode);
      this.view = view;
      this.model = model;
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setMultiSelectionEnabled(false);
      int result = fileChooser.showOpenDialog(view.getTopWindow());
      if (result == JFileChooser.APPROVE_OPTION) {
         File file = fileChooser.getSelectedFile();
         if (file.exists()) {
            if (file.getName().endsWith(".txt")) {
               model.setStatus("Opening file \"" + file.getName() + "\"");

               OpenFileWorker openFileWorker = new OpenFileWorker(file);
               openFileWorker.addPropertyChangeListener(
                     new OpenFileWorkerListener(model));
               openFileWorker.execute();
            } else {
               model.setStatus("File \"" + file.getName()
                     + "\" is not a text file");
            }
         } else {
            model.setStatus("File \"" + file.getName() + "\" does not exist");
         }
      }
   }

}

class OpenFileWorker extends SwingWorker<String, Void> {
   private File file;

   public OpenFileWorker(File file) {
      this.file = file;
   }

   public File getFile() {
      return file;
   }

   @Override
   protected String doInBackground() throws Exception {
      StringBuilder stringBuilder = new StringBuilder();
      Scanner scan = null;
      try {
         scan = new Scanner(file);
         while (scan.hasNextLine()) {
            stringBuilder.append(scan.nextLine() + "\n");
         }

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } finally {
         if (scan != null) {
            scan.close();
         }
      }
      return stringBuilder.toString();
   }
}

class OpenFileWorkerListener implements PropertyChangeListener {
   private MvcModel model;

   public OpenFileWorkerListener(MvcModel model) {
      this.model = model;
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
         OpenFileWorker openFileWorker = (OpenFileWorker) evt.getSource();
         try {
            String text = openFileWorker.get();
            model.setText(text);
            model.setStatus("File \"" + openFileWorker.getFile().getName() + "\" opened");
         } catch (InterruptedException e) {
            e.printStackTrace();
         } catch (ExecutionException e) {
            e.printStackTrace();
         }
      }
   }
}

@SuppressWarnings("serial")
class FileAction extends AbstractAction {
   public FileAction(String name, int keyCode) {
      super(name);
      putValue(MNEMONIC_KEY, keyCode);
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      // pretty much empty
   }
}

@SuppressWarnings("serial")
class SaveToFileAction extends AbstractAction {
   private MvcView view;
   private MvcModel model;

   public SaveToFileAction(MvcView view, MvcModel model, String name,
         int keyCode) {
      super(name);
      putValue(MNEMONIC_KEY, keyCode);
      this.view = view;
      this.model = model;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO finish!
   }
}

@SuppressWarnings("serial")
class ExitAction extends AbstractAction {
   private MvcView view;
   // private MvcModel model; // TODO: may use this later

   public ExitAction(MvcView view, MvcModel model, String name, int keyCode) {
      super(name);
      putValue(MNEMONIC_KEY, keyCode);
      this.view = view;
      // this.model = model; // TODO: may use this later
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      view.getTopWindow().dispose();
   }
}

class ModelListener implements PropertyChangeListener {
   private MvcView view;
   private MvcModel model;

   public ModelListener(MvcView view, MvcModel model) {
      this.view = view;
      this.model = model;
   }

   @Override
   public void propertyChange(PropertyChangeEvent pcEvt) {
      if (MvcModel.TEXT.equals(pcEvt.getPropertyName())) {
         view.setTextAreaText(model.getText());
      }

      else if (MvcModel.STATUS.equals(pcEvt.getPropertyName())) {
         view.setStatusText(model.getStatus());
      }
   }

}