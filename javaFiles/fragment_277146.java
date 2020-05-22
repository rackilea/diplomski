public class JsonResponse
{
    private String name;
    private String code;
    private String releaseDate;
    private String border;
    private String type;
    ArrayList< Object > booster = new ArrayList < Object > ();


    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getBorder() {
        return border;
    }

    public String getType() {
        return type;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", border='" + border + '\'' +
                ", type='" + type + '\'' +
                ", booster=" + booster +
                '}';
    }
}