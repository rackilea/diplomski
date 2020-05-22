Game game = new Game(pending_game.getPlayer(),pending_game.getApplicant());
ofy().save().entity(game).now();    
Key<Game> key_game = Key.create(Game.class, game.getId());          
//We add the new round
Round round = new Round(key_game,generateWord());
ofy().save().entity(round).now();