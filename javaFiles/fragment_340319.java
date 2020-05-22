if(myUniq.containsKey(input)) {
    Integer temp = myUniq.get(input);
    temp = temp + 1;
    myUniq.put(input, temp);
} else {
    myUniq.put(input, 1);
}