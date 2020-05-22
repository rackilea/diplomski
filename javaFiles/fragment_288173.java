public static void main(String[] args) {

    Publisher publisher = new Publisher();
    publisher.publishGame("Pacman");
    publisher.publishGame("Asteroids");
    System.out.println(publisher.getHowManyGamesCreated());
}