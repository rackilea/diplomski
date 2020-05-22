public class GameInput {

    private Scanner scanner;

    /**CLI constructor*/
    public GameInput() {
        scanner = new Scanner(System.in);
    }

    /**GUI constructor*/
    public GameInput(PipedOutputStream out) throws IOException {
        InputStream in = new PipedInputStream(out);
        scanner = new Scanner(in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public static void main(String[] args) throws IOException {
        GameInput gameInput;

        PipedOutputStream output = new PipedOutputStream();
        final PrintWriter writer = new PrintWriter(output);
        gameInput = new GameInput(output);

        final JTextField textField = new JTextField(30);
        final JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = textField.getText();
                writer.println(data);
                writer.flush();
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(textField);
        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);

        String data = gameInput.getInput();
        System.out.println("Input=" + data);
        System.exit(0);
    }

}