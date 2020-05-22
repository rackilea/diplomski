/* Reparent the component and tidy up the tree's state. */
        if (comp.parent != null) {
            comp.parent.remove(comp);
            if (index > component.size()) {
                throw new IllegalArgumentException("illegal component position");
            }
        }