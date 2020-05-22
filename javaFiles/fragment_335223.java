public class DummyTypedQuery implements TypedQuery
    private T singleResult;
    private List resultList;

    public DummyTypedQuery(T singleResult) {
        this.singleResult = singleResult;
    }

    public DummyTypedQuery(List resultList) {
        this.resultList = resultList;
    }

    public DummyTypedQuery() {

    }

    @Override
    public List getResultList() {
        return resultList;
    }

    @Override
    public Object getSingleResult() {
        return singleResult;
    }
        ...the rest of implemented methods, left blank