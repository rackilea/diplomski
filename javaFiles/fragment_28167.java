controller.shuffle();
// Either of:
// 1. push: controller.shuffle() calls player.pickupCards(cards)
// 2. pull: main loop calls player.pickupCards() which in turn calls controller.giveMeMyCards()

while(playersHaveMoreCards()) {
    awaitPlayerMove();
    // Now is the only time when player can make a move. If there is some
    // GUI the main loop could `wait()` on a mutex (until it's awoken when
    // player makes move), in text mode it could simply await input from keyboard.

    // When player makes a move, it calls controller.playCard(player, card)

    cpuController.move();
    // Again, when it controller calculates its move, eventually it simply calls controller.playCard()

    controller.score();
}
announceWinner(controller.getScore());