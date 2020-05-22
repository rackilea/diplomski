ArrayList<int> arrayList = new ArrayList<int>();

int a = 1;
int b = 0;
int n = 1;

while (n++ <= input) {  // input being from the user
    a += b;
    b = a - b;

    char[] fib = Integer.toString(b).toCharArray();
    for (int i = 0; i < fib.length; i++) {
        arrayList.add(fib[i] - '0');
    }
}