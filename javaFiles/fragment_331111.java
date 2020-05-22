public class SpoilerSpan extends ClickableSpan {

    private boolean shown = false;

    public void setShown(boolean shown){
        this.shown = shown;
    }

    public boolean getShown(){
        return this.shown;
    }

    @Override
    public void onClick(View widget) {
        //Toggle the shown state
        setShown(!getShown());
        //Invalidate the view
        widget.invalidate();
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        //Don't call the super method otherwise this may override our settings!
        //super.updateDrawState(ds);

        //No need to disable the default underline style because the super method isn't called.
        //ds.setUnderlineText(false);

        if(getShown()){
            ds.setColor(Color.BLACK);
            ds.bgColor = 0xFFE7DAC2;
        } else {
            //Spoiler is not shown, make the text color the same as the background color
            ds.setColor(0xFFE7DAC2);
            ds.bgColor = 0xFFE7DAC2;
        }
    }
}