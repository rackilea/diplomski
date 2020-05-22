@XmlAttribute(name = "id")
@XmlJavaTypeAdapter(Adapter1 .class)
protected Integer id;

public int getId() {
    if (id == null) {
        return new Adapter1().unmarshal("0");
    } else {
        return id;
    }
}

public void setId(Integer value) {
    this.id = value;
}