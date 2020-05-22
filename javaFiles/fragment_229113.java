import javax.swing.JOptionPane;

class Details {
    private String name;
    private String surname;
    private int age;
    private String gender;
    private double AmountPayout;

    void info() {
        this.name = JOptionPane.showInputDialog(null, "Enter the Patient Name :");
        this.surname = JOptionPane.showInputDialog(null, "Enter the Patient Surname :");
        String rawAge = JOptionPane.showInputDialog(null, "Enter the age of the patient :");
        this.age = Integer.parseInt(rawAge);
        this.gender = JOptionPane.showInputDialog(null, "Enter the Patient gender :");
        String rawPayout = JOptionPane.showInputDialog(null, "Enter the Patient payout :");
        this.AmountPayout = Double.parseDouble(rawPayout);


    }

    void reportPayment() {
        paymentCalculator();
        JOptionPane.showMessageDialog(null, "Victim of Listeriosis" + "\n" + "Patient Name:" + name + " " + surname
                + "\n" + "Age:" + age + "\n" + "Payout:" + AmountPayout);

    }

    private void paymentCalculator() {
        this.AmountPayout = this.AmountPayout * 0.85;
    }
}