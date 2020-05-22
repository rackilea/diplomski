public class GUI {

    private JPanel panel;
    private JProgressBar progressBar;
    private JButton button;

    public GUI(){
        panel = new JPanel();
        progressBar = new JProgressBar();
        button = new JButton("Press me");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker worker = new MySwingWorker();
                worker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(final PropertyChangeEvent event) {
                    switch (event.getPropertyName()) {
                        case "progress":
                            progressBar.setIndeterminate(false);
                            progressBar.setValue((Integer) event.getNewValue());
                            break;
                    }
                }
            });
            //then to get start you have to use execute()
            worker.execute();
            }

        });        
        panel.add(progressBar);
        panel.add(button);


    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI("SwingWorker Example");
            }
        });
    }

    private static void createAndShowGUI(String str) {            
        JFrame frame = new JFrame(str);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(new GUI().panel);
        frame.pack();
        frame.setVisible(true);
    }  


    static class MySwingWorker extends SwingWorker<Void,Void>{
        @Override
        protected Void doInBackground() throws Exception{
            //here you make heavy task this is running in another thread not in EDT
           int i = 0;
           setProgress(i);
           // call query 1
           while(i < 50){
             setProgress(i++);
             Thread.sleep(5); // random magic number
           }
           // then call query 2
           while(i <= 100){
             setProgress(i++);
             Thread.sleep(5); // random magic number
           }

           return null;
        }
    }

}