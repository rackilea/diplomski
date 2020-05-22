// requires b > 1234; 
Pre_1 = b > 1234;
    // requires b > 1234; 
    assume Assignment Pre_1_0_21___4 == b_55 > 1234;
(assert (= BL_58bodyBegin_2 (=> (= _JML___exception_49_49___1 NULL) (=> (= _JML___termination_49_49___2 0) (=> (distinct THIS NULL) (=> (or (= THIS NULL) (and (and (distinct THIS NULL) (javaSubType (javaTypeOf THIS) T_Test)) (jmlSubType (jmlTypeOf THIS) JMLT_Test))) (=> (and (<= (- 2147483648) b_55) (<= b_55 2147483647)) (=> (select _isalloc___0 THIS) (=> (= (select _alloc___0 THIS) 0) (=> (= Pre_1_0_21___3 false) (=> (= Pre_1_0_21___4 (> b_55 1234)) (=> Pre_1_0_21___4 BL_49_AfterLabel_3))))))))))))
a(2345);
    // a(2345)
    int _JML__tmp3 = 2345;
    boolean _JML__tmp6 = _JML__tmp3 > 1234;
    // a(2345)
    int _JML__tmp3 = 2345
    boolean _JML__tmp6 = _JML__tmp3 > 1234
(define-fun _JML__tmp3 () Int 2345)
(define-fun _JML__tmp6 () Bool (> _JML__tmp3 1234))