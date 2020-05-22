import java.util.stream.*

class Item {
    final String name

    Item(name) {
        this.name = name
    }

    @Override
    String toString() {
        name
    }
}

def itemize(String name) {
    Optional.of(new Item(name))
}


def finalCollection = [ 'some', 'items', 'really', 'not', 'important' ].stream()
        .map { itemize(it) } //map String to Optional<Item>
        .flatMap { it.map(Stream.&of).orElseGet(Stream.&empty) } //convert to Stream<Item>
        .collect (Collectors.toList()) 

assert 'java.util.ArrayList' == finalCollection.class.name        
assert finalCollection.collect { it.name } == ['some', 'items', 'really', 'not', 'important']