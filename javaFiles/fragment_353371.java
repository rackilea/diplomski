public static void main(String[] args) {
    int i, i2, i4, a;
    String s1, s2, s3, s4;

    s1 = JOptionPane.showInputDialog("Enter The Number Of Patients");
    i = Integer.parseInt(s1);
    a = 0;
    long totalAges = 0;
    while (a < i) {
        s2 = JOptionPane.showInputDialog("Enter patient's ID");
        i2 = Integer.parseInt(s2);
        s3 = JOptionPane.showInputDialog("Enter patient's Name");

        s4 = JOptionPane.showInputDialog("Enter patient's Age");
        i4 = Integer.parseInt(s4);

        JOptionPane.showMessageDialog(null, " ID : " + i2 + "\n Name : " + s3 + "\n Age : " + i4);

        totalAges += i4;
        a++;
    }

    double avgAge = ((double) totalAges) / i;
    JOptionPane.showMessageDialog(null, " Average Age: " + avgAge);
}