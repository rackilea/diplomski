.....
    private ArrayList<String> input = new ArrayList<String>();
    private ArrayList<String> calcOperators = new ArrayList<String>();
    private ArrayList<Integer> calcOperands = new ArrayList<Integer>();
    private String user_input;
    private String first;
    private String next;
    private String char1;
    private int integer2;
    private int integer1;
}

public static void input()
{
    Scanner input = new Scanner(System.in);
    int int1 = input.nextInt();
    int int2 = input.nextInt();
    string str = input.next();
    string nxt = input.next();

    setInteger1(int1);
    setInteger2(int2);
    setStringFirst(str);
    setStringNext(...);
    ....
    //and so on
}
private void setInteger1(int int1){
    this.integer1 = int1;
}
private Integer getInteger1(){
    return this.integer1;
}
private void setInteger2(int int2){
    this.integer2 = int2;
}
private Integer getInteger2(){
    return this.integer2;
}
private void setStringFirst(String fst){
    this.first = fst;
}
private String getStringFirst(){
    return this.first;
}
// and so on, create all get and set methods for each global var and for future 
// reference do not use variable names that are same as method names 
// and try to use more meaningful variable names. In fact if you look at 
// java naming conventions it would do you good.