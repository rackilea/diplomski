public class Employee {

    @ExcelRow                  
    private int rowIndex;

    @ExcelCell(0)                
    private long employeeId;  

    @ExcelCell(1)
    private String name;

    @ExcelCell(2)
    private String surname;

    @ExcelCell(3)
    private int age;
}