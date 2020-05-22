public class Line{
    public static final String DELIMITER = ",";
    public static final int INDEX_NAME = 0;
    public static final int INDEX_VALUE = 1;

    private String line;
    private String[] values;

    public Line(String line) {
        this.line = line;
        this.values = line.split(DELIMITER);
    }

    public String getName(){
        return this.values[INDEX_NAME];
    }

    public String getValue(){
        return this.values[INDEX_VALUE];
    }

    public void emptyValue(){
        this.values[INDEX_VALUE] = "";
    }

    @Override
    public String toString() {
        return this.line;
    }
}