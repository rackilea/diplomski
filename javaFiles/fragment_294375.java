Button btn = new Button("Run");
    btn.setPreferredSize(new Dimension(200,200)); <------
    btn.setLocation(50,50);//neither this.
    cont.add(btn);
    window.add(cont);
    window.setSize(500,500);
    window.setLocation(400,300);
    window.pack(); <------
    window.setVisible(true);