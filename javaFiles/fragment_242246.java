package wag.contribution.addons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class LayoutSorter {

  @Inject private IEventBroker broker;

  private EventHandler handler;

  // The part IDs we are interested in, sorted in the sequence they should be
  // shown
  private static List<String> PART_IDS = Arrays.asList(new String[] {
              "wag.aView", "wag.bView", "org.eclipse.ui.editorss" });

  // Listen to the e4 core service's event broker to find the magical time
  // when the application is created and try to sort the layout.
  @PostConstruct
  void hookListeners(final MApplication application,
                     final EModelService service) {

    if (handler == null) {
      handler = new EventHandler() {
        // Try to sort the layout. Unsubscribe from event broker if
        // successful.
        @Override
        public void handleEvent(Event event) {
          try {
            sort(application, service);
            // sort did finish: stop listening to the broker.
            broker.unsubscribe(handler);
          } catch (Exception e) {
            // Something went wrong, the application model was not ready yet.
            // Keep on listening.
          }
        }
      };

      // Subscribe "ServiceEvent.MODIFIED" to grab the application.STARTED
      // event. Does anybody know how to do this in a better way?
      broker.subscribe("org/osgi/framework/ServiceEvent/MODIFIED",
                       handler);
    }
  }

  private void sort(MApplication application, EModelService service) {

    // find all placeholders
    List<MPlaceholder> placeholders = service.findElements(application,
              null, MPlaceholder.class, null);

    // only keep the ones we are interested in
    for (int i = placeholders.size() - 1; i > -1; i--) {
      if (!PART_IDS.contains(placeholders.get(i).getElementId())) {
        placeholders.remove(i);
      }
    }

    // find the parents of the placeholders
    List<MElementContainer<MUIElement>> parents = new ArrayList<>(
             placeholders.size());
    for (MPlaceholder placeholder : placeholders) {
      parents.add(placeholder.getParent());
    }

    // find the parent that is "deepest down" in the tree
    MElementContainer<MUIElement> targetParent = null;
    for (MElementContainer<MUIElement> parent : parents) {
      for (MUIElement child : parent.getChildren()) {
        if (parents.contains(child)) {
          continue;
        }
        targetParent = parent;
      }
    }

    // move all parts to the target parent
    if (targetParent != null) {
      for (int i = 0; i < placeholders.size(); i++) {
        if (targetParent != placeholders.get(i).getParent()) {
          service.move(placeholders.get(i), targetParent, i);
        }
      }
    }
  }

  @PreDestroy
  void unhookListeners() {
    if (handler != null) {
      // in case it wasn't unhooked earlier
      broker.unsubscribe(handler);
    }
  }
}