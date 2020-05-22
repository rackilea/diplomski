for(int i = 0; i < a.length;i++) {
    for (int j = i + 1 ; j < a.length; j++) {
        if (a[i] == a[j]) {
            System.out.println("Found duplicate");
            return;
        }
    }
}
System.out.println("No duplicate Found");