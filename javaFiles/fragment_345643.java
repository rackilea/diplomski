private void subMenu(String item) {
    Item obj;
    switch(item) {
        case "employee":
            obj = new Employee();
            break;
        case "article":
            obj = new Article();
            break;
       default:
            return; //FIXME Can it happen?
    }
    obj.edit();
    obj.remove();
    ...
}