class A {
}

A.metaClass.static.createCriteria = {
    [list: 
        {def a = new A(); a.metaClass.totalResult=5; a}
    ]
}

def c = A.createCriteria()
def result = c.list()
println result.totalResult