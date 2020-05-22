// building the model
OrderList waiting = new OrderList();
OrderList finished = new OrderList();
Cook cook = new Cook(waiting, finished);
Customers customers = new Customers(waiting);

// attaching the view
somePanel.add(new JList(waiting));
somePanel.add(new JList(finished));

// building the controller plug-in
CloseKitchen closeKitchen = new CloseKitchen(cook);

// wiring the plugin into the controller
somePanel.add(new JButton(closeKitchen));

// show the view
somePanel.setVisible(true);

// start the cook and customers
cook.start();
customers.start();