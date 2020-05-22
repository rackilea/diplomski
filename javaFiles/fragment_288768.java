@Transactional
public SomeObject eagerGetById(int x){
    SomeObject obj = getById(x);
    obj.getAnotherObject(); // will force loading the object
    return obj;
}