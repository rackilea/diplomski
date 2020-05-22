public class DefaultDateModel extends Observable implements MutableDateModel {

    private LocalDate date;

    public DefaultDateModel(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
        setChanged();
        notifyObservers();
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void removeObserver(Observer o) {
        // I like the "remove" ;)
        deleteObserver(o);
    }

}