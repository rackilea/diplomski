public class PartialResult<T> {

    /** the partial result set */
    private Collection<T> result;

    /** the size of the complete result set */
    private int total;

    public Collection<T> getResult() {
       return this.result;
    }

    public int getTotal() {
       return this.total;
    }

    public void setResult(Collection<T> result) {
       this.result = result;
    }

    public void setTotal(int total) {
       this.total = total;
    }

    public PartialResult(Collection<T> result, int total) {
       super();
       this.result = result;
       this.total = total;
    }