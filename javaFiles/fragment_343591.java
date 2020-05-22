if( (xpos > 683) && (xpos < 920) && (ypos > 440) && (ypos < 478) ) {
    if(Mouse.isButtonDown(0)) {
        sbg.enterState(1);
    }
    //ypos will never be less than 417 because to reach this point it MUST
    //be greater than 440 due to first if statement.
    if ( (xpos > 683) && (xpos < 920) && (ypos > 379) && (ypos < 417) ) {
        if(Mouse.isButtonDown(0)) {
            gc.exit();
        }
    }
}