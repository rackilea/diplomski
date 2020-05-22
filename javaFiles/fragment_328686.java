@Override
public boolean equals(Object d){ 
    if (!(d instanceof Dog)) {
        return false;
    }
    Dog dog = (Dog) d;
    return this.size.equals(dog.size);
}