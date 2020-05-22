import com.teamdev.jxbrowser.chromium.dom.events.DOMEvent;
import com.teamdev.jxbrowser.chromium.dom.events.DOMEventListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyDomEventListener implements DOMEventListener {

    private final ExecutorService executorService;
    private final OrderCreationView view;

    public MyDomEventListener(OrderCreationView view) {
        this.view = view;
        this.executorService = Executors.newCachedThreadPool();
    }

    @Override
    public void handleEvent(DOMEvent domEvent) {
        // Do not block the current thread and invoke the loadView method asynchronously.
        executorService.execute(view::loadView);
    }
}