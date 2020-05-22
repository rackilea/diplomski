for(int i=Lobby.games.size()-1; i>-1; i--) {
  Game g = Lobby.games.get(i);

  // this is now safe, because you're only ever going to see
  // indices lower than the current "i", and the removal
  // only how long Lobby.games is *after* "i", not before it.
  Lobby.games.remove(g)
}