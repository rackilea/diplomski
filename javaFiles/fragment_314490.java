public void initPanel() {

    Collections.shuffle(buttons);

    for(JButton jb:buttons){
        panelButtons.add(jb);
    }

    panel.add(panelButtons, BorderLayout.CENTER);


    pack();
    setSize(500, 300);
    setVisible(true);

}