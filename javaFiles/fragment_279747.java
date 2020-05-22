solveButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("I was pressed");
        StringBuilder stbuld = new StringBuilder();
        int cnt = 0;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                for (int cell = 0; cell < 9; ++cell) {
                    String value = txtfields[cnt].getText();

                    if(value != null && !value.equals(""))
                    {
                        System.out.println(row + ":" + col + ":" + ":" + cell + ":" + value);
                        stbuld.append("["+row + "][" + col + "][" + cell + "] = " + value + "\n");
                    }

                    cnt++;
                }
            }
        }

        output.setText(stbuld.toString());
    }
});