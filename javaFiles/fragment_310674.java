private EventListenerList listeners = null;

    public void addTreeModelListener(TreeModelListener l) {
        if (l == null)
            return;
        if (listeners == null)
            listeners = new EventListenerList();
        listeners.add(TreeModelListener.class, l);
    }

    public void removeTreeModelListener(TreeModelListener l) {
        if (l == null)
            return;
        if (listeners == null)
            return;
        listeners.remove(TreeModelListener.class, l);
    }

    private void fireTreeStructureChanged(TreeModelEvent e) {
        if (e == null)
            return;
        if (listeners == null)
            return;
        TreeModelListener[] ll = listeners.getListeners(TreeModelListener.class);
        for(int i = 0; i < ll.length; i++)
            ll.treeStructureChanged(e);
    }