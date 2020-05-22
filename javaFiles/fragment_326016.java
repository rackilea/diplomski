@Override
public void actionPerformed(ActionEvent e) {
    textarea.append("Start...");
    new Thread(new Runnable(){
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    textarea.append("End");
                }
            });
        }
    }).start();
}