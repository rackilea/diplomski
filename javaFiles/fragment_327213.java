for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        DrawPanel panel = new DrawPanel();
        panels[i][j] = panel;
        MainPanel.this.add(panel);
    }
}