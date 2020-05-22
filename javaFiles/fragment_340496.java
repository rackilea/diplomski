class Dataset {

    private LocalDateTime date;

    @JacksonXmlProperty(localName = "element")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Element> elements;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> element) {
        this.elements = element;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "date=" + date +
                ", element=" + elements +
                '}';
    }
}

class Element {

    private Long id;
    private String name;
    private Long age;
    private RegDate regdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public RegDate getRegdate() {
        return regdate;
    }

    public void setRegdate(RegDate regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "ElementXML{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", regdate=" + regdate.getDate() +
                '}';
    }
}

class RegDate {

    private LocalDateTime date;

    public RegDate() {
        this(null);
    }

    public RegDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegDate{" +
                "date=" + date +
                '}';
    }
}