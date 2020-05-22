private ArrayList<String> generateParenthesis(int n){
    if(n == 1){
        ArrayList<String> result = new ArrayList<String>();
        result.add("()");
        return result;
    }
    ArrayList<String> result = generateParenthesis(n-1);

    ArrayList<String> newResult = new ArrayList<String>();
    for(String str : result){
        newResult.add("("+str+")");
        newResult.add("()"+str);
        newResult.add(str+"()");
    }
    result.addAll(newResult);
    return result;
}