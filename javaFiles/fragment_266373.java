private TranslucentPane panel_Bottom;

//...

panel_Bottom = new TranslucentPane();
panel_Bottom.setBorder(new LineBorder(new Color(0, 0, 0)));
if(isTransparent){
    panel_Bottom.setAlpha(0.85f);
}