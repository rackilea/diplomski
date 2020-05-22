for (Iterator<CastleWarBarricade> it = playingGame.barricades.iterator();
     it.hasNext(); ) {
     CastleWarBarricade npc = it.next();
     if (playingGame.removeBarricade(CastleWars.SARADOMIN, npc) ||
         playingGame.removeBarricade(CastleWars.ZAMORAK, npc)) {
         it.remove();
     }
}