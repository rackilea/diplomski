public class Transport {
    private long fromTimestamp;
    private long toTimestamp;
    private Column[] column;
    ...
}

public class Column {
    private Integer variableId;
    private Integer typeId;
    private boolean time;
    private String period;
    ...
}