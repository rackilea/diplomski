@groovy.transform.TypeChecked
void test() {
    Integer object = Eval.me('1 + 1')
    assert object.class == Integer
}

[Static type checking] - Cannot assign value of type java.lang.Object to variable of type java.lang.Integer