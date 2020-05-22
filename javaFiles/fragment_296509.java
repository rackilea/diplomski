public boolean equals(Object o) {
    if (this == obj) {
        return true;
    } else if (obj == null) {
        return false;
    } else if (!(obj instanceof Bag))
        return false;
    }

    Bag<?> other = (Bag<?>) obj;
    if (this.count != other.count) {
        return false;
    }

    Bag<t> bag1 = new Bag<t>();
    Bag<t> bag2 = new Bag<t>();
    bag1.addAll(this);
    bag2.addAll(other);

    // If you don't know about `static` yet, just use this instead of the following I guess 
    //Bag<t> bag3 = new Bag<t>();
    //bag3 = bag3.union(bag1, bag2);
    Bag<t> bag3 = Bag.union(bag1, bag2);

    t object;
    for(int i=0; i<bag3.size();i++) {
        object = bag3.content[i];
        if ((bag1.contains(object)) && (bag2.contains(object))){
            bag1.remove(object);
            bag2.remove(object);
        }
    }

    return (bag1.isEmpty() && (bag2.isEmpty()));
}