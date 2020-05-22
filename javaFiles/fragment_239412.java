class ApplicationDataModel {

    private Flag current = Flag.RW;

    public void setData(ApplicationData data) {
        current = Flag.RO;
        setDataImpl(data);
        notifyObservers();
        current = Flag.RW;
    }

    public void reaction(Event e) {
        if (flag = Flag.RO) return;
        ...
    }

}