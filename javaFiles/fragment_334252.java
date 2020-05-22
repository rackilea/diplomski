while (true) {
    try {
        // ...
        Inventory i1 = new Inventory(id, "sally", 12, 2, 2);
        System.out.println(i1);
        break; // or return i1 if you enclose this snippet in a function
    } catch (Exception ex) {
        // ...
    }
}