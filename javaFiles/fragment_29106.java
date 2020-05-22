public final class MyProc extends StoredProcedure {

    public MyProc() {
        super(myDataSource, "TESTONE");
        declareParameter(new SqlParameter("param1", Types.CHAR));
        declareParameter(new SqlOutParameter("param2", Types.CHAR));
    }

    public String execute(Map<?, ?> inParams) {
        Map results = super.execute(inParams);
        return (String) results.get("param2");
    }
}