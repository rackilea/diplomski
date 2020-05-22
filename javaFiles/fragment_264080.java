try {
    SwingUtilities.invokeLater(new Runnable(){
        public void run() {
            tip1.setText(ad1.tip1());
            tip2.setText(ad1.tip2());
            tip3.setText(ad1.tip3());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
    });
}