@JsonIgnore
void setTagName(String name)

@JsonProperty("tagnameOpc")
void setTagNameOpc(String name) {
    setTagName(name);
}

@JsonProperty("tagName")
String getTagName()