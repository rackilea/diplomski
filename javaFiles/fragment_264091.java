public class MyPojo{

    @Trim
    @Parsed(index = 0)
    private String myColumn1;

    @Trim
    @Parsed(index = 1)
    private String myColumn2;
}