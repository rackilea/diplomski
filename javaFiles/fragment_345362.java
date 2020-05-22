<CUSTOMER_NO_1>{ 
    (for $test in fn:distinct-values($data_ENV1/ns0:data/ns0:CUST/ns0:CUSTNO)
        return $test)[1]
}</CUSTOMER_NO_1>
<CUSTOMER_NO_2>{    
    (for $test in fn:distinct-values($data_ENV1/ns0:data/ns0:CUST/ns0:CUSTNO)
        return $test)[2]
}</CUSTOMER_NO_2>
<CUSTOMER_NO_3>{    
    (for $test in fn:distinct-values($data_ENV1/ns0:data/ns0:CUST/ns0:CUSTNO)
        return $test)[3]
}</CUSTOMER_NO_3>
<CUSTOMER_NO_4>{    
    (for $test in fn:distinct-values($data_ENV1/ns0:data/ns0:CUST/ns0:CUSTNO)
        return $test)[4]
}</CUSTOMER_NO_4>
<CUSTOMER_NO_5>{    
    (for $test in fn:distinct-values($data_ENV1/ns0:data/ns0:CUST/ns0:CUSTNO)
        return $test)[5]
}</CUSTOMER_NO_5>
<CUSTOMER_NO_6>{    
    (for $test in fn:distinct-values($data_ENV1/ns0:data/ns0:CUST/ns0:CUSTNO)
        return $test)[6]
}</CUSTOMER_NO_6>
<CUSTOMER_NO_7>{    
    (for $test in fn:distinct-values($data_ENV1/ns0:data/ns0:CUST/ns0:CUSTNO)
        return $test)[7]
}</CUSTOMER_NO_7>