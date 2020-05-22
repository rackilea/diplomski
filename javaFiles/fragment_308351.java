public void updateDateTimeUI(){
    timeLabel = new JLabel();
    timeLabel.setText(time);
    timeLabel.setBounds(350, 10, 200, 30);
    timeLabel.setForeground(new Color(255,255,255));
    timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
    timeLabel.setBackground(new Color(Transparency.TRANSLUCENT));
    timeLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
    timeLabel.setOpaque(false);

}