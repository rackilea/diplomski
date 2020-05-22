@Named("ZonesController")
@ViewScoped
public class Zones implements Serializable
{

    @Resource(name = "jdbc/Oracle")
    private DataSource ds;

    public void setDs(DataSource ds){this.ds=ds;}
    public DataSource getDs(){return ds;}

    ...
}