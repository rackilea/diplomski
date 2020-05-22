private List<ListDataListener> listeners = new ArrayList<ListDataListener>();

    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }

    public void add(Data string) {
        this.data.add(string);
        ListDataEvent addition = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, data.size() - 1, data.size() - 1);
        for (ListDataListener l : listeners) {
            l.intervalAdded(addition);
        }
    }

    public void remove(Data d2) {
        data.remove(d2);
        ListDataEvent removal = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, data.size(), data.size());
        for (ListDataListener l : listeners) {
            l.intervalRemoved(removal);
        }
    }