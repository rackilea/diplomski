@Override
public String toString() {
    return
            "Employee name:" + name + "\n" +
            "Salary before bonus: $" + NumberFormat.getNumberInstance(Locale.US).format(salary) + "\n" +
            "Bonus: $" + bonus + "\n" +
            "Salary plus bonus: $" + NumberFormat.getNumberInstance(Locale.US).format(bonus + salary);
}