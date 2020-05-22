public void onMouseWheel(Widget sender, MouseWheelVelocity velocity)
{
    DOM.eventPreventDefault(DOM.eventGetCurrentEvent()); //prevent vertical scroll
    int positionDelta = velocity.getDeltaY() * 30;
    int newPosition = getHorizontalScrollPosition() - positionDelta;
    setHorizontalScrollPosition(newPosition);   
}