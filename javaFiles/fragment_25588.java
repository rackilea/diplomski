ChartComponent ccOne = new ChartComponent(50, 50, 100, 200);
ChartComponent ccTwo = new ChartComponent(10, 10, 10, 10);
JPanel container = new JPanel(); // JPanel uses FlowLayout by default
container.add(ccOne);
container.add(ccTwo);
f.add(container, BorderLayout.CENTER); // just to be clear
f.pack();
f.setVisible(true);