// requires b > 1234.0; 
Pre_1 = b > 1234.0;
    // requires b > 1234.0; 
    assume Assignment Pre_1_0_29___4 == b_72 > 1234.0;
a(2345.0);
    // a(2345.0)
    double _JML__tmp3 = 2345.0;
    boolean _JML__tmp6 = _JML__tmp3 > 1234.0;
    // a(2345.0)
    double _JML__tmp3 = 2345.0
    boolean _JML__tmp6 = _JML__tmp3 > 1234.0
        void z() { a(2345.0); }
        //@ requires b > 1234.0;
Test.java:4:    a(2345.0)
            VALUE: 2345.0    === 0.0