public void actionPerformed(ActionEvent e) {
        square = Integer.parseInt(squareSize.getText());
        squared = square * square;

        centerPanel.setLayout(new GridLayout(square, square));

        for (int i = 0; i < squared; i++) {
            field = new JTextField();
            field.setColumns(3);
            inputFields.add(field);
            centerPanel.add(inputFields.get(i));
            System.out.println("DRAWING");
        }

        add(centerPanel, BorderLayout.CENTER);
        System.out.println("ADDING ADDITINOAL BUTTONS");
        additionalButtons();
        System.out.println("ADDED ADDITINOAL BUTTONS");
        System.out.println("REPAINTING");
        revalidate();
        repaint();
        System.out.println("REPAINTED");
    }