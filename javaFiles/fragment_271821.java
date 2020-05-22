public static Vector<ClassB> convert(Vector<ClassA> v){

    Vector<ClassB> result = new Vector(v.size());

    for(ClassA a : vector){
        result.add(a.toClassB());
    }
    //optional: v.clear()
    return result;
}