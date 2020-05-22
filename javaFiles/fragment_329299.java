public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if(!(obj instanceof Cat))
        return false;
    Cat c = Cat(obj);
    return (this.getName().equals(c.getName()) && this.getColor().equals(c.getColor()));
}