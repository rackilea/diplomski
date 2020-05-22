Memory data = new Memory(256);
Pointer p = foo(data);
Pointer[] parray = p.getPointerArray(0);
for (Pointer p : parray) {
    System.out.println(p.getString(0));
}