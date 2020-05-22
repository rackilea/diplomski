@Test(timeout=1000)
public void game_should_work_on_input() {
    final ByteArrayInputStream stream = new ByteArrayInputStream(String.format("5%nlower%nlower%nnone%n").getBytes());
    final Scanner scanner = new Scanner(stream);
    playGame(scanner);
}