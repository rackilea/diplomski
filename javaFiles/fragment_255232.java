jcomeau@intrepid:~/rentacoder$ cat /tmp/test.java 
public class test {
 public static void main(String[] args) {
  int[][] blah = {{1, 2}, {3, 4, 5}};
  System.out.println("lengths: " + blah.length + ", " + blah[0].length +
   ", " + blah[1].length);
 }
}
jcomeau@intrepid:~/rentacoder$ (cd /tmp && java test)
lengths: 2, 2, 3