public GUTHABEN (SPIELAUTOMAT spielautomat) {
    this.Guthaben = new JLabel("");
    this.Increase = new JButton("Guthaben erhoehen");
    this.Decrease = new JButton("Guthaben verringern");
    this.guthaben = 0;
    this.Spielautomat = spielautomat;
    zeichne();
}