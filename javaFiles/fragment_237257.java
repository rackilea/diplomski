public class Foo {
float value;

public Foo(float value) {
    this.value = value;
}

public Foo(Bar b){
    value = b.value;
}
}