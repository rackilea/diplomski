public static void main(String[] args) {
    recurse(1);
}

public static void recurse (int n) {
    if (n==5) return;
    String temp="";
    for (int i=0;i<n;i++) temp += " ";
    if (n!=1) {
     System.out.println(temp + "This was written by call number " + n + ".");
    }
    recurse(n+1);
    temp=" ";
    for (int i=0;i<n;i++) temp += " ";
    System.out.println(temp + "This ALSO was written by call number " + n + ".");
}