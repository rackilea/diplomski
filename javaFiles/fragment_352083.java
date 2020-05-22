<?php

function pad($n) {
    $n = explode('.', (string)$n);

    if (2 === count($n)) {
        return sprintf("%02d.%d\n", $n[0], $n[1]);    
    }

    return sprintf("%02d\n", $n[0]);    
}

foreach (array(2, 22, 222, 2., 2.11) as $num) {
    echo pad($num);
}

// returns 02, 22, 222, 02, 02.11