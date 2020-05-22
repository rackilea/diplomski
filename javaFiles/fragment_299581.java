@UiField
DisclosurePanel p;

//call this somewhere once on widget creation to 
//prevent header's default click handler
private void myInit()
{
    p.getHeader().unsinkEvents(Event.ONCLICK);
}

@UiHandler("info")
public void onInfoClicked(ClickEvent event)
{
   //trigger "standard" click handler if you want
   if(someCondition) {
       //convert GwtEvent descendant to NativeEvent descendant;
       p.getHeader().onBrowserEvent(event.getNativeEvent().<Event> cast());
   }

   // do something custom, but do not open/close the disclosurepanel
}