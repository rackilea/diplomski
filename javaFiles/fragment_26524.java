public class Repository implements Serializable{

    @Override
    public String toString() {
        return "Repository [repositoryURL=" + repositoryURL + "]";
    }
    private static final long serialVersionUID = -1891563116357617243L;
    private String repositoryURL;

}