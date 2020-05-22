public void setMainView(Canvas canvas)
{
    mainView.destroy();
    mainView = canvas;
    addMember(mainView);
    this.redraw();
}