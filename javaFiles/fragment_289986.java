if ((rows + 1) % 3 == 0) {
    System.out.println("Split");
    split.gridy = gbc.gridy + 1;
    gbc.gridy += 2;
    JPanel sep = new HorizontalSplit();
    add(sep, split);
}