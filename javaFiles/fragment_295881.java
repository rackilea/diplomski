List<Coordinate> route = new ArrayList<>(Arrays.asList(one, two, three));
final MapPolygonImpl mapPolygon = new MapPolygonImpl(route);
map.addMapPolygon(mapPolygon);
toolBar.add(new JButton(new AbstractAction("Remove") {

    @Override
    public void actionPerformed(ActionEvent e) {
        map.removeMapPolygon(mapPolygon);
    }
}));