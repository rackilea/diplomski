if (sessionAttributes == null
                || sessionAttributes.get("userName") == null
                || sessionAttributes.get("userName").equals("")) {

            return "login";
        }else{
if (!((String) sessionAttributes.get("userName")).equals(null)){
return invocation.invoke();
}else{
return "login";
}