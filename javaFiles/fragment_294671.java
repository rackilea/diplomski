boolean isFontLoaded = shell.getDisplay().loadFont("A.ttf");

if(isFontLoaded)
{
    Font font = new Font(shell.getDisplay(), "name of the font", 12, SWT.NORMAL);
    myText.setFont(font);
}