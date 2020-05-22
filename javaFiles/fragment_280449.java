final Container purchaseDemo = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    final Purchase p = Purchase.getInAppPurchase();

    if(p != null) {
        if(p.isManualPaymentSupported()) {
            purchaseDemo.addComponent(new Label("Manual Payment Mode"));
            final TextField tf = new TextField("100");
            tf.setHint("Send us money, thanks");
            Button sendMoney = new Button("Send Us Money");
            sendMoney.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    p.pay(Double.parseDouble(tf.getText()), "USD");
                }
            });
            purchaseDemo.addComponent(tf);
            purchaseDemo.addComponent(sendMoney);
        } 
        if(p.isManagedPaymentSupported()) {
            purchaseDemo.addComponent(new Label("Managed Payment Mode"));
            for(int iter = 0 ; iter < ITEM_NAMES.length ; iter++) {
                Button buy = new Button(ITEM_NAMES[iter]);
                final String id = ITEM_IDS[iter];
                buy.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        p.purchase(id);
                    }
                });
                purchaseDemo.addComponent(buy);
            }
        } 
    } else {
        purchaseDemo.addComponent(new Label("Payment unsupported on this device"));
    }