protected void initGameAndGUI(GameContainer arg0, StateBasedGame arg1) {

    LwjglInputSystem inputSystem = new LwjglInputSystem();

    try {
        inputSystem.startup();
    } catch (Exception e) {
        e.printStackTrace();
    }           
    PlainSlickInputSystem psis = new PlainSlickInputSystem();
    GameClient.app.getInput().addListener(psis);    

    prepareNifty(nifty, arg1);
    nifty = new Nifty(new LwjglRenderDevice(), new NullSoundDevice(),psis, new AccurateTimeProvider());
    NullSoundDevice(),psis, new AccurateTimeProvider());    
    initNifty(arg0, arg1, psis);    
    nifty.fromXml("...");

}