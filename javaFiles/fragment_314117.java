class Person {
    String first, last, middle
}

def p1 = new Person(first: 'bob')
def p2 = new Person(last: 'barker')

Person merged = (p1.properties.findAll { k, v -> v }  // p1's non-null properties
               + p2.properties.findAll { k, v -> v }) // plus p2's non-null properties
               .findAll { k, v -> k != 'class' }      // excluding the 'class' property

assert merged.first == 'bob'
assert merged.last == 'barker'
assert merged.middle == null