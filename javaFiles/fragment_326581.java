public class Test extends JFrame {

    public Test() {
        setSize(100, 100);
        setVisible(true);
    }



    public static void main(final String[] args) {
        final Timer timer = new Timer();

        final Test test = new Test();

        final TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                test.bringToFront();
            }
        };

        timer.schedule(timerTask, 5000, 5000);
    }



    private void bringToFront() {
        final ScriptEngineManager mgr = new ScriptEngineManager();
        final ScriptEngine engine = mgr.getEngineByName("AppleScript");

        try {
            engine.eval("tell me to activate");
        } catch (final ScriptException ex) {
            ex.printStackTrace();
        }
    }
}