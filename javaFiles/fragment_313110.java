class CustomModel extends DefaultButtonModel
{


    @Override
    public void setPressed(boolean b){
        if((isPressed() == b) || !isEnabled()) {
            return;
        }

        if (b) {
            stateMask |= PRESSED;
        } else {
            stateMask &= ~PRESSED;
        }

        fireStateChanged();
    }

}