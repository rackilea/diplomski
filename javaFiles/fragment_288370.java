interface Card {
  void pick(Player player);
}

class DrawCard implements Card {
  void pick(Player player) {
    player.draw(value); // assume value passed in e.g. ctor
  }
}