public Notification<MyModel> addMyModel(MyModelDTO myModelDTO){
    Notification<MyModel> notification = new Notification();
    //if(JSR 303 bean validation errors) -> notification.pushError(...); return notification;
    //if(business logic violations) -> notification.pushError(...); return notification;
    return notification;
}