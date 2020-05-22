char[] array = new char[] { 'a', 'B', 'c', 'R', 'n', 'k', 'W', 'v', 't', 'G', 'L', };
int n = 0;
for (int i = 0; i < array.length; i++) {
    if (Character.isUpperCase(array[i])) {
        n++;
    }
}
System.out.println(n);