public class TestApplet extends Applet {

    private String ip;

    public void init() {
        try {
            URL ipCheck = new URL("http://checkip.amazonaws.com");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ipCheck.openStream()));
            ip = bufferedReader.readLine();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.CYAN);
        g.drawString("Current IP: " + ip, 10, 20);
    }

}