@Transactional
public MyObject create(MyObject myObject) {

    //createdMyObject and  myObject are same instance  

    MyObject createdMyObject = this.myObjectRepository.save(myObject);
    return createdMyObject;
}