public final class SwingWorkerDemo {
    private static JLabel label = 
        new JLabel(String.valueOf(0), SwingConstants.CENTER);

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createAndShowGUI();             
            }
        });

        JLabelSwingWorker workerThread = new JLabelSwingWorker();
        workerThread.run();
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class JLabelSwingWorker extends SwingWorker<Void, Integer>{
        @Override
        protected Void doInBackground() throws Exception {
            for(int i = 1; i < 31; i++){
                Thread.sleep(1000);
                publish(i);
            }
            return null;
        }

        @Override
        protected void process(List<Integer> integers) {
            Integer i = integers.get(integers.size() - 1);
            label.setText(i.toString());
        }
    }
}