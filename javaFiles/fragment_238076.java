class abc {
   void fun(int n) {
    if (n > 0) {
        System.out.println(n);
        fun(n - 1);
    }
}

public static void main(String args[]) {
    int x = 3;
    abc a = new abc();
    a.fun(x);
}
}