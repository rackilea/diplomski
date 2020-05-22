public class Base {
    protected final Queue<Customer> customers;

    protected Base(Queue<Customer> c) {
        this.customers = c;
    }
}

public class Sub1 extends Base {
     Sub1() {
        super(new WhateverQueue<Customer>());
     }
}

public class Sub2 extends Base {
     Sub2() {
         super(new PriorityQueue<Customer>());
     }
}