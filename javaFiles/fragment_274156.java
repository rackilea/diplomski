public class MyNotifyingArrayList<E> extends ArrayList<E> {

  private Notifiable notifiable;

  public MyNotifyingArrayList(Notifiable notifiable) {
    this.notifiable = notifiable;
  }

  @Override
  public boolean add(E e) {
    boolean success = super.add(e);
    if (success) {
        notifiable.notify(e);
    }
    return success;
  }
}