import javax.swing.*;

class GetInput {

    public static void getInput() {
        String result = JOptionPane.showInputDialog(null, "Enter something");
        if (result==null) {
            System.out.println("User cancelled action.");
        } else {
            System.out.println("User entered '" + result + "'.");
        }
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                getInput();
                getInput();
            }
        });
    }
}