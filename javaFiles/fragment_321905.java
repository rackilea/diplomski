import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Map;

class POJO {

    private Integer status;
    private Integer complete;
    private String error;
    private Long since;

    @JsonProperty("search_meta")
    private SearchMeta searchMeta;

    private Map<String, Item> list;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Long getSince() {
        return since;
    }

    public void setSince(Long since) {
        this.since = since;
    }

    public SearchMeta getSearchMeta() {
        return searchMeta;
    }

    public void setSearchMeta(SearchMeta searchMeta) {
        this.searchMeta = searchMeta;
    }

    public Map<String, Item> getList() {
        return list;
    }

    public void setList(Map<String, Item> list) {
        this.list = list;
    }
}

class SearchMeta {

    @JsonProperty("search_type")
    private String searchType;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}

class Item {

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("resolved_id")
    private String resolvedId;

    // more attributes here

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getResolvedId() {
        return resolvedId;
    }

    public void setResolvedId(String resolvedId) {
        this.resolvedId = resolvedId;
    }
}