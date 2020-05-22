container.setLayout(layout);
....
    if (ali.equals("left")){
        layout.setAlignment(FlowLayout.LEFT);
    }
    ...
    container.revalidate();
    container.repaint();