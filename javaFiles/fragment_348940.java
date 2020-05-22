package com.fillpant.examples;

public class EventCaller {
//This class calls an event, and all the listeners will have to handle it;

    public void callClickEvent(){
        Event e = new ClickEvent();
        for(Listener l : all_registered_listeners){//this is hypothetical, if we had listeners.
            l.event(e);
        }
        if(e.isCanceled()) return;
        else{
            //DoStuff
        }
    }

}