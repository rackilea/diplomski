class LocalClass {
    final int val$y;
    final Main this$0;

    LocalClass(Main arg1, int arg2) {
        this.this$0 = arg1; // bytecode 1-2
        this.val$y = arg2; // bytecode 5-7
        super(); // bytecode 10-11
        System.out.println(this.val$y); // bytecode 14-21
    }
}