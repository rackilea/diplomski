//If this is adding/setting to a list, make sure the object has the proper class type
if(
    instance instanceof java.util.List && //Object is a list
    java.util.Arrays.asList("add", "set").contains(method.getName()) //Adding/setting to list
) {
    //If this is a TypedList, use its stored class for the typecheck
    java.util.List TheInstanceList=(java.util.List)instance;
    Class ClassInstance=null;
    if(instance instanceof lua.TypedList)
        ClassInstance=((lua.TypedList)instance).GetListClass();
    //Otherwise, check for a 0th object to typecheck against
    else if(TheInstanceList.size()>0) //List already has at least 1 item
        ClassInstance=TheInstanceList.get(0).getClass(); //Class of the 0th item

    //Check if new item does not match found class type
    if(
        ClassInstance!=null && //Only check if there is a class to check against
        !ClassInstance.isInstance(a[a.length>1 ? 1 : 0]) //Check the last parameter's class
    )
        return LuaValue.error(String.format(
                "list coercion error: %s is not instanceof %s",
                a[a.length>1 ? 1 : 0].getClass().getName(),
                ClassInstance.getName()
        ));
}