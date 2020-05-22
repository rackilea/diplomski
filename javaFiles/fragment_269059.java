<?php

// define class
class ConfigData
{
    var $intVal;
    var $tmpData;
}

$cData = new ConfigData();             // new ConfigData instance
$array[0] = $cData;                 // put it in a single element array
$array[0]->intVal = 5;                 // assign an integer to intVal
$array[0]->tmpData = array(1, 1, 2);  // assign an array of whatever to tmpData

foreach($array[0]->tmpData as $val)   // iterate through assigned array
    echo $val." ";                     // print array item (and append " " )

?>