// aliases for java's verbose methods
public static void p(char c) { System.out.print(c); }
public static void pn(char c) { System.out.println(c); }

// convenient shortcut for alternating between characters
public static char[] a = {'/', '\\'};

public static void dotop(int size, int line) {
    p('|');
    for (int i=0; i<size-line; i++) p('.');
    for (int i=0; i<line+1; i++) p(a[i%2]);
    for (int i=0; i<line+1; i++) p(a[(i+1+line)%2]);
    for (int i=0; i<size-line; i++) p('.');
    pn('|');
}

public static void dobottom(int size, int line) {
    p('|');
    for (int i=0; i<size-line; i++) p('.');
    for (int i=0; i<line+1; i++) p(a[(i+line+(line+1)%2)%2]);
    for (int i=0; i<line+1; i++) p(a[(i+1+(line+1)%2)%2]);
    for (int i=0; i<size-line; i++) p('.');
    pn('|');
}

public static void main(String[] args) {
    int size = 4;
    for (int i=0; i<=size; i++) dotop(size, i);
    for (int i=0; i<=size; i++) dobottom(size, size-i);
}