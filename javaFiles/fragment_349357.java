for(int i = 0; i < 5; ++i) 
{
   final int finalI = i;
   levelButtons[i].setAction(ActionType.GENERAL_ACTION, new GameAction() 
   {
       @Override
       public void execute(int screenID) 
       {
         Game.instance.changeScreen( ScreenFactory.produce(ScreenFactory.GAME_SCREEN, finalI));
       }
    });
    TouchHandler.instance.register(levelButtons[i]);
}