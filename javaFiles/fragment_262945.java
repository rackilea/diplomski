public class ExpenseItem {

private String name;
public double amount;
public double frequency;
public double total;

public static double totalAcumulator = 0;  //here is the trick
public ExpenseItem(String name, double amount, double frequency) {
    this.name = name;
    setAmount(amount);
    setFrequency(frequency);
    totalAcumulator += annualTotal(); // and you call it every time you construct an object.
}