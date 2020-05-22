Stack<String> temp = new Stack<>();
while(!history.isEmpty()){
    System.out.println(history.peek());
    temp.push(history.pop);
}
while(!temp.isEmtpy){
    history.push(temp.pop);
}