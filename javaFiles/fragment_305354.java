public gameStateButton(float xpos, float ypos, GameState gameState,     GameStateManager gsm, String buttonMsg) {
    this.gameState = gameState;
    this.gsm = gsm;
    this.pos.xpos = xpos;
    this.pos.ypos = ypos;
    this.buttonMsg = buttonMsg;
    setBounds((int)pos.xpos, (int)pos.ypos, width, height);
    defaultImage = Assets.getButton_notHoveredOver();
}