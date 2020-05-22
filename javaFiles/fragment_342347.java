setLayout(new GridBagLayout());

        dayCurrent = new JTextField(3);
        hourCurrent = new JTextField(3);
        monthCurrent = new JTextField(3);
        yearCurrent = new JTextField(3);
        dayNext = new JTextField(3);
        hourNext = new JTextField(3);
        monthNext = new JTextField(3);
        yearNext = new JTextField(3);
        enter = new JButton("Ok");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(1, 1, 1, 1);

        add(new JLabel("Day"), gbc);
        gbc.gridx++;
        add(new JLabel("Month"), gbc);
        gbc.gridx++;
        add(new JLabel("Year"), gbc);
        gbc.gridx++;
        add(new JLabel("Hour"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(new JLabel("Current Time:"), gbc);
        gbc.gridx++;
        add(dayCurrent, gbc);
        gbc.gridx++;
        add(monthCurrent, gbc);
        gbc.gridx++;
        add(yearCurrent, gbc);
        gbc.gridx++;
        add(hourCurrent, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(new JLabel("Next Time:"), gbc);
        gbc.gridx++;
        add(dayNext, gbc);
        gbc.gridx++;
        add(monthNext, gbc);
        gbc.gridx++;
        add(yearNext, gbc);
        gbc.gridx++;
        add(hourNext, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(enter, gbc);