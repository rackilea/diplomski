int i = 0;
    for (String s : colors.keySet()) {
        jrbColor[i] = new JRadioButton(s);
        group.add(jrbColor[i]);
        p1.add(jrbColor[i]);
        jrbColor[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String hexColor = colors.get(((JRadioButton) e.getSource()).getText());
            getContentPane().setBackground(Color.decode(hexColor));
        }
        });
    }