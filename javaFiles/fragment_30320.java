e1.hello();
        e1.count = e1.count + 1;   
           //adds 1 to the memory location which was already 1 from last time and now equals 2
        if (x==3){  // x is 1 so doesn't go in
            e2.count = e2.count +1;
        }
        if(x>0){  // x is 1 so goes in as 1 is greater than 0
            e2.count = e2.count + e1.count;  // adds e2 and e1 = 2 + 2 from previous line above = 4
        }
        x = x+1;
        System.out.println("e1.count is " + e1.count);
        System.out.println("e2.count is " + e2.count);
    }
    System.out.println(e2.count);
}