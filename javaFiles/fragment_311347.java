public abstract class Dessert {

protected final String name;

public Dessert (String name) {
this.name = name;
}

public final String getName() {
  return name;
}
public abstract double getPrice ();
}



public class Cookie extends Dessert {
private int number;
private double price;

public Cookie (String name, int number, double price) {
  super (name);
  this.number = number;
  this.price = price;
}

public int getItemCount() {
  return number;
}

public double getPricePerDozen() {
  return (price/12) * number;
}

public double getPrice() {
  return getPricePerDozen();
}
}