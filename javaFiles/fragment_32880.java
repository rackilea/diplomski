MenuPane menuPane = new MenuPane();
DefaultMenuController controller = new DefaultMenuController(menuPane);

SubMenuPane ebanking = new SubMenuPane("E-Banking");
ebanking.addAction(new AbstractMenuAction(controller, "Deposit") {
    @Override
    public void actionPerformed(ActionEvent e) {
        getController().popLastMenu();
        SubMenuPane deposit = new SubMenuPane("Options").addAction(new AbstractMenuAction(getController(), "Request") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        }).addAction(new AbstractMenuAction(getController(), "Query") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        });
        getController().addSubMenu(deposit);
    }
}).addAction(new AbstractMenuAction(controller, "Credit") {
    @Override
    public void actionPerformed(ActionEvent e) {
        getController().popLastMenu();
        SubMenuPane deposit = new SubMenuPane("Credit-Options").addAction(new AbstractMenuAction(getController(), "Request") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        }).addAction(new AbstractMenuAction(getController(), "Query") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        });
        getController().addSubMenu(deposit);
    }
}).addAction(new AbstractMenuAction(controller, "Exchange") {
    @Override
    public void actionPerformed(ActionEvent e) {
        getController().popLastMenu();
        SubMenuPane deposit = new SubMenuPane("Exchange-Options").addAction(new AbstractMenuAction(getController(), "Request") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        }).addAction(new AbstractMenuAction(getController(), "Query") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        });
        getController().addSubMenu(deposit);
    }
}).addAction(new AbstractMenuAction(controller, "Simulation") {
    @Override
    public void actionPerformed(ActionEvent e) {
        getController().popLastMenu();
        SubMenuPane deposit = new SubMenuPane("Simulation-Options").addAction(new AbstractMenuAction(getController(), "Request") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        }).addAction(new AbstractMenuAction(getController(), "Query") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        });
        getController().addSubMenu(deposit);
    }
}).addAction(new AbstractMenuAction(controller, "Information") {
    @Override
    public void actionPerformed(ActionEvent e) {
        getController().popLastMenu();
        SubMenuPane deposit = new SubMenuPane("Information-Options").addAction(new AbstractMenuAction(getController(), "Request") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        }).addAction(new AbstractMenuAction(getController(), "Query") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use Card layout to show next avaliable options
            }
        });
        getController().addSubMenu(deposit);
    }
});
controller.addSubMenu(ebanking);