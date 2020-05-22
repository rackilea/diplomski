for (int i = 0; i < a.length - 1; i++) {
    if (a[i] != a[i + 1]) {
        System.out.println("now what : " + a[i]);
        list.add(i);
    }
}