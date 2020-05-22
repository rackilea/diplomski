System.out.println(p.countX("xxhixx"));

int count;
int countKeep;
int i;

public int countX(String str) {
  if (i < str.length()) {
      System.out.println("i in outer if is " +i);
        if (str.charAt(i) == 'x') {
          count++;
          System.out.println("count in inner if is " + count);
        }
      i++;
      System.out.println("i is " +i);
      countKeep = count;
      System.out.println("countKeep is " + countKeep);
      countX(str);
  }
  System.out.println("Finished the countX() method");
  return countKeep;
}