public class Boot {

    public static void main(String[] args) {
        System.getProperties().setProperty("socksProxySet", "true");
        System.getProperties().setProperty("socksProxyHost", "71.9.127.141"); //Credits to HideMyAss.com
        System.getProperties().setProperty("socksProxyPort", "28045");//Credits to HideMyAss.com

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TestApplet testApplet = new TestApplet();
                testApplet.init();
                JFrame jFrame = new JFrame();
                jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jFrame.setSize(500, 500);
                jFrame.setContentPane(testApplet);
                jFrame.setVisible(true);
            }
        }).start();
    }

}