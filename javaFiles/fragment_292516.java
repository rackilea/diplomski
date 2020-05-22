@Column(name = "IMAGE")
public byte[] getImage() {
    return image;
}

public void setImage(byte[] image) {
    this.image = image;
}

@Column(name = "CONTENT_TYPE")
public String getContentType() {
    return contentType;
}

public void setContentType(String contentType) {
    this.contentType = contentType;
}
@Transient
public String getIconImage() {
    return "data:" + getContentType() + ";base64,"
            + Base64.encode(getImage());
}