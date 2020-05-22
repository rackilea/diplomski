protected void combat(List<Character> heroes, List<Character> enemies) {
  if (heroes.isEmpty() || enemies.isEmpty()) {
    //one of the parties wins
    return;
  }

  List<Pair<Character, Character>> vs = new LinkedList<>();
  int i = 0;
  while ( i< heroes.length() && i< enemies.length()) {
   vs.add(heroes.get(i), enemies.get(i));
   ++i;
  }
  for (Pair<Character, Character> fight : vs) {
   //figure out the loser
   Character loser = fight(vs.getFirst(), vs.getSecond();
   if (loser.isEnemy()) {
     enemies.remove(loser);
   } else {
      heroes.remove(loser);
   }
  }
  combat(heroes, enemies);
}