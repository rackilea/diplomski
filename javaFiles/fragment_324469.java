private Game game;

// executed before each test method
@Before
public void setup(){
    Game game = new Game();
    game.addPlayer(new Player(...));
}

@Test
public void addASecondSettlement(){
    // context
    game.getPlayer().addSettlement(new Settlement(1));
    // action
    game.getPlayer().addSettlement(new Settlement(2));
    //assertion
    Assert.assertEquals(2, game.findLastSetllement().getId());
}