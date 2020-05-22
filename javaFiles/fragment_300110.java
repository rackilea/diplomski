@Override
@Transactional
public void update(SomeObject someObj) throws BusinessServiceException {
    ...
    someObjectRepository1.update(someObj);
    newClassInstance.newMethod(someObj);

    //New code below:
    someObjectRelatedService.doStuff(someObj); 
    //Throws error, object does not exist in someObjectRepository2
}