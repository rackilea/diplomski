//class resolver according "session_type" parameter
//note, that you can use Spring autowiring capabilities
private final Map<String, Class> TYPES_CONTEXT = new HashMap<String, Class>(){
    {
        this.put("x", TypeX.class);
        this.put("y", TypeY.class);
        //TODO probably other classes
    }
}


@RequestMapping(method = RequestMethod.POST,
        value = "/url")
public @ResponseBody String handleAnyType(@RequestBody Map<String, String> body){
    String sessionType = body.get("session_type");

    //TODO handle case if sessionType is NULL

    Class convertedClass = TYPES_CONTEXT.get(sessionType);

    //TODO handle case if class is not found

    Object actualObject = objectMapper.convertValue(body, convertedClass);

    //now we use reflection for actual handlers, but you may refactor this in the way you want, f.e. again with Strategy pattern
    //note that current approach there should be contract for methods names
    Method actualHandler = this.getClass().getMethod("handle" + actualObject.getClass().getSimpleName());

    return (String)actualHandler.invoke(this, actualObject);
}

public String handleTypeX(TypeX typeX){
    //TODO implement
}

public String handleTypeY(TypeY typeY){
    //TODO implement
}

//TODO probably other methods