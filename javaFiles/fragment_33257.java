public void startClock() {
    Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            //... Update time and schedule repaint
        }
    }
}