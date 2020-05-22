public class TableBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int iTotalRecords;

    private int iTotalDisplayRecords;

    private String sEcho;

    private List data;

    public TableBean(int iTotalRecords, int iTotalDisplayRecords, String sEcho, List data) {
        super();
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.sEcho = sEcho;
        this.data = data;
    }

    // ... getters and setters
}