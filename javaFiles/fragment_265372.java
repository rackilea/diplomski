//compilation of this code will fail with message
//[Static type checking] - The variable [blah] is undeclared.
@groovy.transform.CompileStatic
def f(){
    blah blah blah
}
f()