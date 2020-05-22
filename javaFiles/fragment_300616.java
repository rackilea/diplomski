public interface Contributors {
    public List<Contributor> getContributors();
}

public interface Contributor {
    public String getName();
    public String getContributorUrl();
    public List<String> getRoles();
}