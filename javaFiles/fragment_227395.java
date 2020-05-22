public class abstract AxisModel<T> {
 abstract T method();
}

public class PriceAxisModel extend AxisModel<Double> {
 public Double method() {
  //do stuff
 }
}

public class DateAxisModel extend AxisModel<Date> {
 public Date method() {
  //do stuff
 }
}