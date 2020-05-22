public class Second() {
    private final First first;

    public Second(First first) {
        this.first = first;
    }

    public void actionPerformed(ActionEvent e) {
        this.first.stop();
    }
}