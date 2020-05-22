List<Integer> answer = new ArrayList<Integer>();
boolean canFindChange = findChange(change, coinTypes, answer);
if(canFindChange) {
    System.out.println(answer); // your desired output.
}
else {
    System.out.println("Can't find change!");
}