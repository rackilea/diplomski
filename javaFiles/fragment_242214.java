public class Genre {

@SerializedName("mal_id")
@Expose
private Integer malId;
@SerializedName("type")
@Expose
private String type;
@SerializedName("name")
@Expose
private String name;
@SerializedName("url")
@Expose
private String url;

public Integer getMalId() {
return malId;
}

public void setMalId(Integer malId) {
this.malId = malId;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

}