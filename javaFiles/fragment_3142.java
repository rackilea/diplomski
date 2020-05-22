public class GymMemb2 {
    private int age;
    private int months;

    public GymMemb2(int age, int months) {
        this.age = age;
        this.months = months;
    }

    public int getAge() {
        return age;
    }

    public int getMonths() {
        return months;
    }

    public double getMonthlyRate() {
        // calculations using age and months for monthly rate
        // return result
    }

    public String print() {
        String text = "age: " + age + ", months: " + months;
        // also add monthly rate info
        return text;
    }

}