if (current.name.compareTo(node.name) == 0 && current.age < node.age) {
        node.nextName = current.nextName;
        current.nextName = node;
    } else if (current.name.compareTo(node.name) < 0 ) {
        previous.nextName = current;            
        current.nextName = node;
    } else {
        previous.nextName = node;
        node.nextName = current;
    }