public class Example extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Timer timer;

    public Example() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JTextField field = new JTextField(10);
        add(field);

        JButton startTimer = new JButton("Start");
        startTimer.addActionListener(e -> {
            try {
                LocalTime selectedTime = LocalTime.parse(field.getText(), formatter);
                LocalDateTime selectedDate = LocalDateTime.now().toLocalDate().atStartOfDay();
                selectedDate = selectedDate.plusHours(selectedTime.getHour()).plusMinutes(selectedTime.getMinute())
                        .plusSeconds(selectedTime.getSecond());
                // Check if time has passed and should be scheduled for tomorrow
                if (selectedDate.isBefore(LocalDateTime.now())) {
                    selectedDate = selectedDate.plusDays(1);
                }
                long date = Timestamp.valueOf(selectedDate).getTime();
                long delay = date - System.currentTimeMillis();
                timer = new Timer((int) delay, e1 -> {
                    JOptionPane.showMessageDialog(null, "Time passed.");
                });
                timer.setRepeats(false);
                timer.start();
                System.out.println("Timer started and scheduled at: " + selectedDate);
            } catch (DateTimeParseException e1) {
                JOptionPane.showMessageDialog(null, "Cannot parse date.");
                System.out.println(e1);
            }
        });
        add(startTimer);

        setSize(300, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Example().setVisible(true);
        });
    }
}