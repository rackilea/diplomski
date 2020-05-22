Classname newC = new Classname(a, b, ...);
for ( Classname existing : name ) {
    if ( newC.equals(existing) ) {
        return existing;
    }
}
name.add(newC);
return newC;