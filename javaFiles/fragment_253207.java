private Actor actionManager = new Actor();

//when creating actions:
actionManager.addAction(repeatAction);

//In render(), use this instead of calling act on individual actions
//It will call act on all actions in the actor:
actionManager.act(Gdx.graphics.getDeltaTime());