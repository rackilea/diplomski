public class Project {
    private String name;
    private String path;
    private Integer quantity;
    private List<ProjectDirectory> projectDirectoryList;

    //Constructor
    public Project(String name, String path, Integer quantity, List<ProjectDirectory> projectDirectoriesList) {
        super();
        this.name = name;
        this.path = path;
        this.quantity = quantity;
        this.projectDirectoryList = projectDirectoriesList;
    }
    //GETTERS AND SETTERS
}

public class ProjectDirectory {
    private String name;
    private String path;

    //Constructor
    public ProjectDirectory(String name, String path) {
        super();
        this.path = path;
        this.name = name;
    }

    //Getters & setters