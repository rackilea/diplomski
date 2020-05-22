public static void main(String[] args) throws InterruptedException {
    Timer timer = new Timer();
    TimerTask tt = new TimerTask() {
        public void run() {
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            if(hour == 8) {
                String url = "http://www.youtube.com";
                if(Desktop.isDesktopSupported()){
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(new URI(url));
                    } catch (IOException | URISyntaxException e) {
                        e.printStackTrace();
                    }
                } else {
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        runtime.exec("xdg-open " + url);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
    timer.schedule(tt, 0, 1000);
}