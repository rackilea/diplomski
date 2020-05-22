List<Cost> costs = new ArrayList<Cost>();
cost.add (new Cost(100, Cost.Currency.GOLD));
cost.add (new Cost(200, Cost.Currency.COPPER));

for (Cost cost: costs) {
    ImageIcon icon = createImageIcon(cost(i).getImageName());
    JLabel label1 = new JLabel(cost(i).getAmount(), icon, JLabel.CENTER);
}