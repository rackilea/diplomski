public class DelayedSearch extends JFrame {
    public DelayedSearch() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextField field = new JTextField(30);
        panel.add(field, BorderLayout.NORTH);
        final JLabel status = new JLabel(" ");
        panel.add(status, BorderLayout.SOUTH);
        this.add(panel);
        this.pack();
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        field.addKeyListener(new KeyAdapter() {
            private ScheduledFuture<?> scheduled;
            @Override
            public void keyTyped(KeyEvent e) {
                if (scheduled != null) scheduled.cancel(false);
                scheduled = executor.schedule(new Runnable() {
                    @Override
                    public void run() { // Perform search here. Just set status for demo.
                        status.setText("Search: " + field.getText());
                    }
                }, 1, TimeUnit.SECONDS);
            }
        });
    }
    public static void main(String[] args) {
        new DelayedSearch().setVisible(true);
    }
}