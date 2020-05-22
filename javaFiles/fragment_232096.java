Status status;

if (someMyTypeObject instanceof MyType) { // It's a MyType object

    MyType myTypeObject = (MyType) someMyTypeObject;
    status = myTypeObject.getStatus();

} else { // It's a MyNewType object

    MyNewType myNewTypeObject = (MyNewType) someMyTypeObject;
    status = myNewTypeObject.getObjectStatus();

}