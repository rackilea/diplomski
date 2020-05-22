public static void main(String[] args) {
    PetUI p = new PetUI();
    p.setJMenuBar(menuBar);
    p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    p.setSize(640, 480);
    p.setVisible(true);
    Thread game = new Thread(new Runnable(){
        public void run() {
            while (true) { // while(mainPet.isAlive())
                happinessBar.setValue((int) Math.round(mainPet.getHappiness()));
                healthBar.setValue((int) Math.round(mainPet.getHealth()));
                hungerBar.setValue((int) Math.round(mainPet.getHunger()));
                mainPet.setHappiness(mainPet.getHappiness() - 0.1);
                mainPet.setHunger(mainPet.getHunger() - 0.5);
                // the rest of your game method
            }
        }
    }
    game.start();
}