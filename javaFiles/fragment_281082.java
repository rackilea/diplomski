button.setOnClickListener( new OnClickListener()
{
    public void onClick( ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY )
    {
        (buttonListeners.get(button.id))).onClick(pButtonSprite, pTouchAreaLocalX, pTouchAreaLocalY);
    }      
});