Map.metaClass.addNested = { Map rhs ->
    def lhs = delegate
    rhs.each { k, v -> lhs[k] = lhs[k] in Map ? lhs[k].addNested(v) : v }   
    lhs
}

def map1 = [
    "a" : "1",
    "animals" : ["cat" : "blue"]
]

def map2 = [
    "b" : 2,
    "animals" : ["dog" : "red"]
]

assert map1.addNested( map2 ) == [
    a: '1', 
    animals: [cat: 'blue', dog: 'red'], 
    b: 2
]