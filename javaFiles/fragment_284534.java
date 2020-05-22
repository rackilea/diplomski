public class SomeSource extends BasicDataSource implements Serializable {
    public static final long serialVersionUID = 4467486478647684235L;
    public static SomeSource dataSource;

    public SomeSource(){
        super();
        /* implementation*/
        ....
        dataSource = this;
    }
}