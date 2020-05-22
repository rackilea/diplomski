public class Customer {
  protected int _id;
  protected String _name;
  protected float _balance;

  public Customer() {
    init(0, "New Customer", 0.00f);
  }

  public Customer(int id, String name, float balance) {
    init(id, name, balance);
  }

  private void init(int id, String name, float balance) {
    id(id).name(name).balance(balance);
  }

  public int id() {
    return this._id;
  }
  public Customer id(int id) {
    this._id = id;
    return this;
  }

  public String name() {
    return this._name;
  }
  public Customer name(String name) {
    this._name = name;
    return this;
  }

  public float balance() {
    return this._balance;
  }
  public Customer balance(float balance) {
    this._balance = balance;
    return this;
  }

  public String toString() {
    return String.format("#%d: %-5s - $%07.2f", id(), name(), balance());
  }
}