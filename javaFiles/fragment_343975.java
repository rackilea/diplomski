public String eval(HashMap<String, String> mapValue, String variable) {
    //get expression to be evaluated
    String tmp = mapValue.get(variable); 
    // For each knwon operation
    for (String op : OPERATIONS) { 
        // split expression in operators in Array
        String[] vars = tmp.split("\\" + op); 
        // for each Element of splitted expr. Array
        for (int i = 0; i < vars.length; i++) { 
            //Check if Element is a valid key in HashMap
            if (mapValue.containsKey(vars[i])) { 
                //if it is replace element with result of iteration
                vars[i] = eval(mapValue, vars[i]); // DO ITERATION
            }
            //if Element is not a valid key in has do nothing
        }
        //Join splitted string with proper operator
        tmp = join(vars, op);
    }
    //return in parenthesis
    return "(" + tmp + ")";
}