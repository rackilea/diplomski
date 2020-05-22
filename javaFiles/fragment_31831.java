Class[] candidates = new Class[]{InheritedClass1.class, InheritedClass2.class, InheritedClass3.class};
ObjectMapper mapper = new ObjectMapper();
String jsonInString = "{\"your\":\"json\"}";
AbstractClass instance = null;
for(Class clazz : candidates) {
    try{
        instance = mapper.readValue(jsonInString, clazz);
    } catch (Exception e){
    }
    if(instance !== null) {
        break;
    }
}
System.out.println(instance);