public class Monday {

@SerializedName("mal_id")
@Expose
private Integer malId;
@SerializedName("url")
@Expose
private String url;
@SerializedName("title")
@Expose
private String title;
@SerializedName("image_url")
@Expose
private String imageUrl;
@SerializedName("synopsis")
@Expose
private String synopsis;
@SerializedName("type")
@Expose
private String type;
@SerializedName("airing_start")
@Expose
private String airingStart;
@SerializedName("episodes")
@Expose
private Integer episodes;
@SerializedName("members")
@Expose
private Integer members;
@SerializedName("genres")
@Expose
private List<Genre> genres = null;
@SerializedName("source")
@Expose
private String source;
@SerializedName("producers")
@Expose
private List<Object> producers = null;
@SerializedName("score")
@Expose
private Object score;
@SerializedName("licensors")
@Expose
private List<Object> licensors = null;
@SerializedName("r18")
@Expose
private Boolean r18;
@SerializedName("kids")
@Expose
private Boolean kids;

public Integer getMalId() {
return malId;
}

public void setMalId(Integer malId) {
this.malId = malId;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getImageUrl() {
return imageUrl;
}

public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

public String getSynopsis() {
return synopsis;
}

public void setSynopsis(String synopsis) {
this.synopsis = synopsis;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getAiringStart() {
return airingStart;
}

public void setAiringStart(String airingStart) {
this.airingStart = airingStart;
}

public Integer getEpisodes() {
return episodes;
}

public void setEpisodes(Integer episodes) {
this.episodes = episodes;
}

public Integer getMembers() {
return members;
}

public void setMembers(Integer members) {
this.members = members;
}

public List<Genre> getGenres() {
return genres;
}

public void setGenres(List<Genre> genres) {
this.genres = genres;
}

public String getSource() {
return source;
}

public void setSource(String source) {
this.source = source;
}

public List<Object> getProducers() {
return producers;
}

public void setProducers(List<Object> producers) {
this.producers = producers;
}

public Object getScore() {
return score;
}

public void setScore(Object score) {
this.score = score;
}

public List<Object> getLicensors() {
return licensors;
}

public void setLicensors(List<Object> licensors) {
this.licensors = licensors;
}

public Boolean getR18() {
return r18;
}

public void setR18(Boolean r18) {
this.r18 = r18;
}

public Boolean getKids() {
return kids;
}

public void setKids(Boolean kids) {
this.kids = kids;
}

}