public static void gameRun(){
    SwingWorker<Void, Image> worker = new SwingWorker<Void, Image>() {

        @Override
        protected Void doInBackground() throws Exception {
            for(int x = 0; x < myImages.length; x++) {
                Thread.sleep(1000);
                Image icon = ImageIO.read(myImages[x]);
                publish(icon);
            }
            return null;
        }

        @Override
        protected void process(List<Image> icon) {
            myLabel.setIcon(new ImageIcon(icon.get(icon.size()-1)));
        }
    };
    worker.execute();
}