public int compareTo(Car d){
    if(this.weight>d.weight)
        return 1;
    else if(this.weight<d.weight)
        return -1;
    return this.name.compareTo(d.name);
}