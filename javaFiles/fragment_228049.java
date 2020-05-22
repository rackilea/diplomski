public class Main {

    public static void main(String[] args) {

        JTextField fName = new JTextField();
        fName.setName("First Name");
        JTextField lName = new JTextField();
        lName.setName("last Name");
        JTextField address = new JTextField();
        address.setName("Address");

        JTextField[] fields = new JTextField[] {fName, lName, address};

        StringBuilder sb = new StringBuilder("<html>");
        for (JTextField field : fields) {
            if (field.getText().isEmpty()){
                field.setBackground(Color.RED);
                sb.append("<p>").append("You haven't entered " + field.getName());
            }
        }

        JLabel label = new JLabel(sb.toString());
    }
}