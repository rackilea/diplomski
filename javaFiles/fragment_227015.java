public String printNum() {
    StringBuilder sb = new StringBuilder(128);
    for (int i=0;i<numbers.length;i++)
    {
        System.out.println("Roll " + (i+ 1) + ": " + numbers[i]);
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(numbers[i]);
    }        
    return sb.toString();
}