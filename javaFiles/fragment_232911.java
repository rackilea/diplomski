public Map() {
        setLayout(new GridBagLayout());

        button.addActionListener(this);

        add(button);

        create();
        draw();
    }

    private void draw() {
        if (flag) {
            cellPane.drawPlayer();
        }
        else {
            cellPane.drawWall();
        }
    }

    private void create() {
        GridBagConstraints gbc = new GridBagConstraints();

        cellPane = new CellPane();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(cellPane, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        flag = false;
        draw();
    }