import gov.bop.rabid.datahandler.bean.InmateDataBean;
import gov.bop.rabid.datahandler.main.EventListener;
import gov.bop.rabid.datahandler.main.InmatePhotoEventListener;
import gov.bop.rabid.datahandler.main.InmatePhotoEventObject;

import java.util.ArrayList;
import java.util.List;

public class InmatePhotoListenerHandler {

    protected List<EventListener> listeners;

    public InmatePhotoListenerHandler() {
        listeners = new ArrayList<EventListener>();
    }

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener listener) {
        for (int i = listeners.size() - 1; i >= 0; i--) {
            EventListener instance = listeners.get(i);
            if (instance.equals(listener)) {
                listeners.remove(i);
            }
        }
    }

    public void fireEvent(final InmatePhotoEventObject eo, 
            final InmateDataBean inmate) {
        for (int i = 0; i < listeners.size(); i++) {
            final EventListener instance = listeners.get(i);
            Runnable runnable = new Runnable() {
                public void run() {
                    eo.setInmate(inmate);
                    instance.handleEvent(eo);
                }

            };
            new Thread(runnable).start();
        }
    }

    public static void main(String[] args) {
        System.out.println("This line goes in your DataHandlerMain class "
                + "constructor.");
        InmatePhotoListenerHandler handler = new InmatePhotoListenerHandler();
        System.out.println("I need you to put the commented method in "
                + "DataHandlerMain so I can use the handler instance.");

        // public InmatePhotoListenerHandler getInmatePhotoListenerHandler() {
        //      return handler;
        // }

        System.out.println("This line goes in the GUI code.");
        handler.addListener(new InmatePhotoEventListener());

        System.out.println("Later, when you've received the response from "
                + "the web service...");
        InmateDataBean inmate = new InmateDataBean();
        inmate.setIntKey(23);
        handler.fireEvent(new InmatePhotoEventObject(handler), inmate);
    }
}