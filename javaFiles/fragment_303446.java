public boolean isPathHelper(Node node, String input, int count){
    if(input.length() == 0){
        return false; //I can't go any further: return "failed"
    }
    else if(count == input.length()){
        return true; //if I ever reach here, then I am done: return "success"
    }
    // else call self recursively
    return isPathHelper(
      getNextState(node, input.charAt(0) -'0'), input.substring(1), count+1);
}