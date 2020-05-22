String s = "Successfully logged in...";
// better use System.out.print() than out.print() *
System.out.print(s);  
Thread.sleep(2000); // Wait 2 seconds

// print as backspaces as charactes printed using CommonLangs
StringUtils.repeat("\b", s.length);    

// print as backspaces as charactes printed with for loop
for (i = 0; i < s.length; i++) {
    System.out.print("\b");
}