<?php
$count = 0;
foreach(file("http://www.google.com") as $line) {
    echo $line, PHP_EOL;
    if(strpos('br', $line)) { 
        ++$count;
    echo $count, PHP_EOL;
    }

}