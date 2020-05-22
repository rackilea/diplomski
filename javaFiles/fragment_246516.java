//If this is adding/setting to a list, make sure the object type matches the list's 0th object type
java.util.List TheInstanceList;
if(
    instance instanceof java.util.List && //Object is a list
    java.util.Arrays.asList("add", "set").contains(method.getName()) && //Adding/setting to list
    (TheInstanceList=(java.util.List)instance).size()>0 && //List already has at least 1 item
    !a[a.length>1 ? 1 : 0].getClass().isInstance(TheInstanceList.get(0)) //New item does not match type of item #0
)
    return LuaValue.error(String.format(
            "list coercion error: %s is not instanceof %s",
            a[a.length>1 ? 1 : 0].getClass().getName(),
            TheInstanceList.get(0).getClass().getName()
    ));