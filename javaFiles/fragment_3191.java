@Override
public boolean supports(Class<?> clazz) {

    Class<?>[] supportedClasses = {

            UserDTO.class,
            Collection.class,
            Long.class
    };
    for(Class<?> c : supportedClasses){
        if(clazz.isAssignableFrom(clazz)(c)){
            return true;
        }
    }
    return false;
}