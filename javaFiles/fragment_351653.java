for(Types type : typeList) {
    if(type instanceof ClassA || type instanceof ClassB) {
        counter++;
    }
}
return counter;