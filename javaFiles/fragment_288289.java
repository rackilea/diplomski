if (object1.getArguments().size() != object2.getArguments.size()) {
   ... // they don't even have the same number of arguments, this is the first check
} else {

    for(String variableName : object1.getArguments().keySet()) {
        if(!object2.getArguments().contains(variableName)) {
            ... // bad match !
            break;
        } else {
           Argument arg1 = object1.getArguments().get(variableName);
           Argument arg2 = object2.getArguments().get(variableName);
           ... // do some comparison here
        }
    }
}