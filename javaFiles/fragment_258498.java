public static void main(String [] args) {
        JFrame frame = new JFrame("My Frame");
          JPanel panel = new JPanel(new GridLayout(1,2)); // split the panel in 1 rows and 2 cols


          JTextArea userField = new JTextArea("User:");
          userField.setEditable(false);

          JTextArea user = new JTextArea("myuser");
          user.setEditable(true);

          panel.add(userField);
          panel.add(user);

          frame.getContentPane().add(panel);

          frame.setVisible(true);
          frame.setSize(500, 500);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }