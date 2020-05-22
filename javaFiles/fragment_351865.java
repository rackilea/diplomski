public Board() {
    GridLayout grid_grelha = new GridLayout(linhas, colunas, 3, 3);
    setLayout(grid_grelha);
    setOpaque(true);
    setSize(janela_x - 140, janela_y-140);
    setLocation(70, 20);
    setBackground(Color.GREEN);
    // criar JLabels
    for (int num = 0; num < linhas; num++){
        for (int num2 = 0; num2 < colunas; num2++){
            JLabel label = new JLabel();
            //label.setText(String.format("%d,%d",num,num2));
            label.setOpaque(true);
            label.setBackground(select_cor(num,num2));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            add(label);
            labels[num][num2]=label;
        }
    }
}