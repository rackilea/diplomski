private void createComponents() {
        textBox = new JTextField("    ");
        submit = new JButton("Submit");
        label = new JLabel("Please enter a windspeed:");
        errorLabel = new JLabel("Error Message " );

        JPanel upper = new JPanel();
        upper.setLayout(new BoxLayout(upper,BoxLayout.X_AXIS));
        upper.add(label);
        upper.add(textBox);
        upper.add(submit);
        upper.add(errorLabel);
        JPanel lower = new JPanel();
        lower.setLayout(new BoxLayout(lower,BoxLayout.X_AXIS));
        lower.add(tornado);
        JPanel over = new JPanel();
        over.setLayout(new BoxLayout(over,BoxLayout.Y_AXIS));
        over.add(upper);
        over.add(lower);
        add(over);
        tornado.repaint();
    }