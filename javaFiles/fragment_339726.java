<?php
$LAT_VARIABLE = $_REQUEST['MyLat'];
$LONG_VARIABLE = $_REQUEST['MyLong'];
$ALT_VARIABLE = $_REQUEST['MyAlt'];
$PRO_VARIABLE = $_REQUEST['MyProvider'];
$ACC_VARIABLE = $_REQUEST['MyAccuracy'];

echo "Number 1: ".$LAT_VARIABLE."";
echo "Can you see the value?";

error_log("Lat: " . $LAT_VARIABLE, 0);

?>