public class HourSpinner implements ChangeListener {

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new HourSpinner();
        }
    });
}

public HourSpinner() {

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 70);
    frame.setLocationRelativeTo(null);

    Container contentPane = frame.getContentPane();

    JSpinner dateSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
    DateEditor editor = new JSpinner.DateEditor(dateSpinner, "HH:mm:ss");
    dateSpinner.setEditor(editor);
    dateSpinner.addChangeListener(this);

    contentPane.add(dateSpinner);

    frame.setVisible(true);

}

@Override
public void stateChanged(ChangeEvent e) {
    JSpinner source = (JSpinner) e.getSource();
    System.out.println(source.getValue());
}

}