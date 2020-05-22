@Sheet
public class Employee {

    @SheetColumn("Age")
    private Integer age;

    @SheetColumn("Name")
    public String getName() {
        return name;
    }

}