Field loginVariaable = .../// get your login attribute from your Class Object using reflection 
Order order = loginVariaable.getAnnotation(Order.class)
int orderValue = order.value();

Input inputObject = loginVariaable.getAnnotation(Input.class)
String inputName= inputObject.name();