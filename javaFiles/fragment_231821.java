private static void doSomething(int[] list) {
int[] b = list; // this means list and b are referring to the same array that was being referenced by list reference variable
for (int i = 0; i < b.length; i++) {
    b[i] = i;
  }
}