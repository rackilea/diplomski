public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        JFrame frame = new JFrame("Test...");
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> latch.countDown());
        frame.add(button);
        frame.pack();
        frame.setVisible(true);

        // Wait here for the click in the event thread
        latch.await();

        System.out.println("Clicked!");

        frame.dispose();
    }
}