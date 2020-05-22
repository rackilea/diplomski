class Fizz{
}

Fizz.metaClass.doOtherStuff = {return "more blah"}
def fizz = new Fizz()
assert fizz.doOtherStuff() == "more blah"

def fizz1 = new Fizz()
assert fizz1.doOtherStuff() == "more blah"