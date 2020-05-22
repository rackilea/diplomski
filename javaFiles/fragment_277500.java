private void CreateDrawingPanel()
{
    drawingPanel = new JPanel(){

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawLine(100, 100, 120, 500);
        }
    };

    add(drawingPanel, BorderLayout.CENTER);
    drawingPanel.setBackground(Color.white);
}