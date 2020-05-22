public class BusyMask extends VLayout
{
    public BusyMask()
    {
    RootPanel.get().add(this);
    hide();
    setOpacity(50);
    setBackgroundColor("#000000");
    setPositionAndSizes();
    this.getParentElement().addResizedHandler(
        new ResizedHandler()
            {

                @Override
                public void onResized(ResizedEvent event)
                {
                    setPositionAndSizes();

                }
            });
    }

@Override
public void show()
{
    this.bringToFront();
    super.show();
}

@Override
public void hide()
{
    super.hide();
}

protected void setPositionAndSizes()
{
    setWidth100();
    setHeight100();

    setLeft(0);
    setTop(0);
}
}