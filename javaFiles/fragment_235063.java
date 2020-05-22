void addObject(){
    int count = objects1.size()
    objects1.put(count, new MyTestObject())
    objects2.put(count, new MyTestObject())
}

void addObject(MyTestObject testObject){
    int count = objects1.size()
    objects1.put(count, testObject)
    objects2.put(count, testObject)
}