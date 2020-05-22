@Transactional
    public MyObject create(MyObject myObject) {
        //createdMyObject, myObject and (due to 1st level cache) 
        //object returned from query are same 

        MyObject createdMyObject = this.myObjectRepository.save(myObject);
        return this.myObjectRepository.findById(createdMyObject.getMyObjectId());
    }