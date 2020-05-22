private void Start(int clothes, int food, int repair, int money) {
    Iceberg Tim = new Iceberg();
    Tim.addGameListener(new GameListener() {
        @Override
        public void completed(Iceberg berg) {
            f.dispose();
        }
    });

    f.add(Tim);
    f.setVisible(true);
    f.setSize(600, 600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setTitle("SAILIN BABEEEEY");
    f.setLocation(600, 200);
}