public class TestMVC {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final ModelBean model = new ModelBean();
                GUI gui = new GUI(model);
            }
        });
    }
}