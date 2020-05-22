public class MainResponse {

@SerializedName("request_hash")
@Expose
private String requestHash;
@SerializedName("request_cached")
@Expose
private Boolean requestCached;
@SerializedName("request_cache_expiry")
@Expose
private Integer requestCacheExpiry;
@SerializedName("monday")
@Expose
private List<Monday> monday = null;

public String getRequestHash() {
return requestHash;
}

public void setRequestHash(String requestHash) {
this.requestHash = requestHash;
}

public Boolean getRequestCached() {
return requestCached;
}

public void setRequestCached(Boolean requestCached) {
this.requestCached = requestCached;
}

public Integer getRequestCacheExpiry() {
return requestCacheExpiry;
}

public void setRequestCacheExpiry(Integer requestCacheExpiry) {
this.requestCacheExpiry = requestCacheExpiry;
}

public List<Monday> getMonday() {
return monday;
}

public void setMonday(List<Monday> monday) {
this.monday = monday;
}

}