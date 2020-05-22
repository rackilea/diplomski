void addObject(){
    int count = objects1.size()
    def newTestObject = new MyTestObject()
    objects1.put(count, newTestObject)
    objects2.put(count, newTestObject)
}