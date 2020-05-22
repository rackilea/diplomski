package testingThings.ServerSentEvent;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    public static final String ATTR_ENTRY_PROCESSOR_PROGRESS = "entryProcessorProgress";

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        write(httpSessionBindingEvent);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        write(httpSessionBindingEvent);
    }

    private void write(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals(ATTR_ENTRY_PROCESSOR_PROGRESS)) {
            try {
                // get the AsyncContext from the session
                AsyncContext aCtx = (AsyncContext) httpSessionBindingEvent.getSession().getAttribute("asyncContext");
                String message = "data: " + httpSessionBindingEvent.getValue() + "<br>\n\n";
                aCtx.getResponse().getWriter().write(message);
                aCtx.getResponse().getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}