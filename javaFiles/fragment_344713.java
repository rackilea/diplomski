public void setButton(final JFreeChart chart, JButton button) {
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            TextTitle title = chart.getTitle();
            Font font = title.getFont();
            float size = font.getSize();
            title.setFont(font.deriveFont(size + 2));
        }
    });
}