public String printNum() {
    StringJoiner joiner = new StringJoiner(", ");
    for (int i=0;i<numbers.length;i++)
    {
        System.out.println("Roll " + (i+ 1) + ": " + numbers[i]);
        joiner.add(Integer.toString(numbers[i]));
    }        
    return sb.toString();
}