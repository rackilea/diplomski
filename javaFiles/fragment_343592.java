if( (xpos > 683) && (xpos < 920) && (ypos > 440) && (ypos < 478) ) {
    if(Mouse.isButtonDown(0)) {
        sbg.enterState(1);
    }
}
//exit Game
if ( (xpos > 683) && (xpos < 920) && (ypos > 379) && (ypos < 417) ) {
    if(Mouse.isButtonDown(0)) {
        gc.exit();
    }
}