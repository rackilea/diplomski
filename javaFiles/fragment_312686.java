@SpringBootApplication
public class SpringDesktopSampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringDesktopSampleApplication.class).headless(false).run(args);
    }

    @Override
    public void run(String... args) {
        JFrame frame = new JFrame("Spring Boot Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JPanel panel = new JPanel(new BorderLayout());
        JTextField text = new JTextField("Spring Boot can be used with Swing apps");
        panel.add(text, BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}