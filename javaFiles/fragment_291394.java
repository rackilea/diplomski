Button closeButton = new Button(...);
Container myTitle = new Container(new BorderLayout());
myTitle.setUIID("DialogTitleArea");
myTitle.add(BorderLayout.CENTER, new Label("My Title", "DialogTitle")).
       .add(BorderLayout.EAST, closeButton);
dlg.add(BorderLayout.NORTH, myTitle);