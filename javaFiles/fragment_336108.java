@Table(name = "formresource")
public class FormResource extends Model implements Serializable{

    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    Type formresourcelistType = new TypeToken<List<FormResource>>(){}.getType();


    @SerializedName("resources")
    @Expose
    private List<FormResource> resources = new ArrayList<FormResource>();

    @Column(name = "resources")
    @Expose
    private String resourcelist;


    public List<FormResource> getResources() {
        return resources;
    }

    public void setResources(List<FormResource> resources) {
        this.resources = resources;
    }

    public void setResourcelist()
    {
        this.resourcelist=gson.toJson(resources,formresourcelistType);
    }

    public List<FormResource> getResourceList() {

        List<FormResource> resourceList=gson.fromJson(this.resourcelist,formresourcelistType);
        return resourceList;
    }

}