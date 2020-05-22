@Embeddable
public final class MyBean extends Number implements Serializable, Comparable<MyBean> {

    private Long myValue;

    public MyBean(Long myValue) {
        this.myValue = myValue;
    }

    // Other helper methods and overrides

    public MyBean valueOf(Long data) {
        return new MyBean(data);
    }

    @Override
    public String toString() {
        return String.valueOf(myValue);
    }

}