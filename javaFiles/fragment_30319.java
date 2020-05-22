e1.hello();
        e1.count = e1.count + 1;   //adds 1 to the memory location
        if (x==3){  // x is 0 so doesn't go in
            e2.count = e2.count +1;
        }
        if(x>0){  // x is 0 so doesn't go in
            e2.count = e2.count + e1.count;
        }
        x = x+1;
        System.out.println("e1.count is " + e1.count);
        System.out.println("e2.count is " + e2.count);
    }
    System.out.println(e2.count);
}