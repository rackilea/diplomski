@XmlElement(nillable=true)
public String getFooString() {
    return fooString;
}

public void setFooString(String foo) {
    this.fooString = foo;
    this.setFoo = true;
}