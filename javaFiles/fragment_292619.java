public void setText(String s1, String s2, String s3) {
        JLabel label1 = new JLabel(s1);
        label1.setBounds(100, 100, 500, 500);
        JLabel label2 = new JLabel(s2);
        label2.setBounds(75, 20, 100, 20);
        JLabel label3 = new JLabel(s3);
        label3.setBounds(100, 20, 100, 20);
        add(label1);// Add the label to your current JPanel
        add(label2);
        add(label3);

    }