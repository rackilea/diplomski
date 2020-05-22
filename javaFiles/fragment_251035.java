private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {        
    int len = touchEvents.size();

    for(int i = 0; i < len; i++) {
        TouchEvent event = touchEvents.get(i);
        if(event.x < 64 && event.y < 64) {
            if(event.type == TouchEvent.TOUCH_UP) {
                // ...
            }
        else if (event.x >= 120 && event.x <= 180 && event.y >= 250 && event.y <= 380) {
            switch(event.type) {
                case TouchEvent.TOUCH_UP:
                    uiState.updateButtonState(ButtonState.RELEASED);
                    break;
                case TouchEvent.TOUCH_DOWN:
                    Assets.click.play(1);
                    uiState.updateButtonState(ButtonState.PRESSED);
                    break;
                default:
                    // nothing to do
            }
        }
    }

    world.update(deltaTime);

    // I suppose an invalidation has happened / a redraw will happen next
}

private void drawRunningUI() {
    Graphics g = game.getGraphics();
    g.drawPixmap(uiState.getButtonState() == ButtonState.PRESSED ? Assets. buttonPressed : Assets.buttonUnpressed,70,200);
}