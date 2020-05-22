class GridPanel extends JPanel{

    JLabel mountain, map, animal;

    public GridPanel(JPanel panel){
        super();
        setLayout(new GridLayout(2, 2));
        animal = new JLabel(new ImageIcon(getClass().getResource("pictures/animal.gif")));
        map = new JLabel(new ImageIcon(getClass().getResource("pictures/map.gif")));
        mountain = new JLabel(new ImageIcon(getClass().getResource("pictures/mountain.gif")));
        add(panel);
        add(mountain);
        add(map);
        add(animal);
    }

}