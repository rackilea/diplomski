public class BatchProcessor {
    private BusinessUnitDao budao;

    public BatchProcessor(BusinessUnitDao dao) {
        this.budao = dao;
    }

    public List<BusinessUnit> process() {
       // process budao.load() list here
    }
}