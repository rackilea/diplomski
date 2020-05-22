class Child extends Super {
    int three = 0;//initialization to proper value is moved to constructors
                  //                                   |
    Child(){      //                                   |
        super();  //                                   |
        three = (int) Math.PI;  //<--------------------+
    }
    ...
}