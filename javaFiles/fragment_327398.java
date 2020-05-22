public interface DateModel {

    public LocalDate getDate();

    public void addObserver(Observer o);

    public void removeObserver(Observer o);
}

public interface MutableDateModel extends DateModel {

    public void setDate(LocalDate date);

}