public interface WindowConfigurer {
    void configure(JFrame window);
}

public class DefaultWindowConfigurer implements WindowConfigurer {

    private Font font = // Default font

    public void configure(JFrame window) {
        window.setFont(font);
    }

    public void setFont(Font font) {
        this.font = font;
    }
}

public class EntryPoint {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Something something = new Something();
                WindowConfigurer windowConfigurer = new DefaultWindowConfigurer();
                windowConfigurer.configure(something);
                something.setVisible(true);
            }
        });
    }
}

public class Something extends JFrame {
    public Something() {
        // .. add buttons, controls, etc.
    }
}