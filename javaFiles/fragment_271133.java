public class pojo {


private Title title;
private String link;
private String type;
private String status;
private String slug;
private String modified_gmt;
private String modified;
private Guid guid;
private String date_gmt;
private String date;
private int id;

public Title getTitle() {
    return title;
}

public void setTitle(Title title) {
    this.title = title;
}

public String getLink() {
    return link;
}

public void setLink(String link) {
    this.link = link;
}

public String getType() {
    return type;
}

public void setType(String type) {
    this.type = type;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public String getSlug() {
    return slug;
}

public void setSlug(String slug) {
    this.slug = slug;
}

public String getModified_gmt() {
    return modified_gmt;
}

public void setModified_gmt(String modified_gmt) {
    this.modified_gmt = modified_gmt;
}

public String getModified() {
    return modified;
}

public void setModified(String modified) {
    this.modified = modified;
}

public Guid getGuid() {
    return guid;
}

public void setGuid(Guid guid) {
    this.guid = guid;
}

public String getDate_gmt() {
    return date_gmt;
}

public void setDate_gmt(String date_gmt) {
    this.date_gmt = date_gmt;
}

public String getDate() {
    return date;
}

public void setDate(String date) {
    this.date = date;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public static class Title {
    private String rendered;

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }
}

public static class Guid {
    private String rendered;

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }
}
 }