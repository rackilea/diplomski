public static void main(String[] args) {
    // prompt user to input a number

    String input = JOptionPane.showInputDialog("Enter number ");
    // change string to int
    int number = Integer.parseInt(input);

    // display message to user of their results
    BigInteger num = new BigInteger(input);

    String output = num + " is" + (IsPrime(num) ? " " : " not ")
            + "a prime number.";

    JOptionPane.showMessageDialog(null, output);
}