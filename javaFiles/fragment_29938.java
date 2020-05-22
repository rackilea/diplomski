private LinkedHashSet<String> generateParenthesis(int n){
    if(n == 1){
        LinkedHashSet<String> result = new LinkedHashSet<String>();
        result.add("()");
        return result;
    }
    LinkedHashSet<String> result = generateParenthesis(n-1);

    LinkedHashSet<String> newResult = new LinkedHashSet<String>();
    for(String str : result){
        newResult.add("("+str+")");
        newResult.add("()"+str);
        newResult.add(str+"()");
    }
    result.addAll(newResult);
    return result;
}