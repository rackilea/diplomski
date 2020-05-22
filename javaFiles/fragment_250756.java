@Field("statusCreatedDate")
@JsonProperty
private Date statusCreatedDate = new Date();

public void setStatusCreatedDate(Date created) {
    this.statusCreatedDate = created;
}