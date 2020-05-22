package com.myspace.project;
//from row number: 1

    rule "Row 1 gui"
        dialect "mvel"
        when
            $c : Customer( $b : balance, $d : discount)
        then
            modify( $c ) {
                    setIncome( $b*$d*10 )
            }
    end