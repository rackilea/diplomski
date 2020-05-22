if(start == null){
    start = temp;
    last = temp;
}

//insert before
if(temp.letter < start.letter){
    temp.nodeptr = start;
    start = temp;   
}