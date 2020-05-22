class Foo{
private String nameFoo;

private String numberOfFoo;

public Foo() {}

public Foo(String nameFoo, String numberOfFoo) {
    this.nameFoo=nameFoo;
    this.numberOfFoo=numberOfFoo;

}

public String getNameFoo() {
    return nameFoo;
}

public void setNameFoo(String nameFoo) {
    this.nameFoo = nameFoo;
}

public String getNumberOfFoo() {
    return numberOfFoo;
}

public void setNumberOfFoo(String numberOfFoo) {
    this.numberOfFoo = numberOfFoo;
}

@Override
public String toString() {
    return "Foo [nameFoo=" + nameFoo + ", numberOfFoo=" + numberOfFoo + "]";
   }
}