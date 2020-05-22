public class Program {
@Expose
private doublea.models.Airtime Airtime;
@Expose
private String id;
@Expose
private String title;
@SerializedName("short_name")
@Expose
private String shortName;
@SerializedName("full_description")
@Expose
private String fullDescription;
@SerializedName("short_description")
@Expose
private String shortDescription;
@Expose
private doublea.models.Image Image;
@SerializedName("image")
@Expose
private String imageName;
@Expose
private List<Host> hosts = new ArrayList<Host>();
@Expose
private List<Category> categories = new ArrayList<Category>();
@Expose
private List<Airtime> airtimes = new ArrayList<Airtime>();

/** Getters and Setters */

public Program() {
}