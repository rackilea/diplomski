List<Car> cars = new ArrayList<>();
....
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Car car : cars) {
        car.drawCar(g);
    }
}