CompletableFuture<String> future = new CompletableFuture<>();

SwingUtilities.invokeLater(() -> {
    JFrame f = new JFrame("EDT Blocking Example");
    f.setSize(200, 200);
    JLabel label = new JLabel();
    JButton button = new JButton("Click & Wait");
    button.addActionListener(l -> {
        try {
            // calling get() will block the EDT here...
            String text = future.get();
            label.setText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    JPanel content = new JPanel();
    content.add(button);
    content.add(label);
    f.setContentPane(content);
    f.setVisible(true);
});
System.out.print("Enter some text: ");
String input = new Scanner(System.in).nextLine();

future.complete(input);