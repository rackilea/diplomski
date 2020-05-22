<?php

$sqlroom = mysql_query("SELECT * FROM `room_table`");
$room_rows = array();
while($r = mysql_fetch_assoc($sqlroom)) {
  $room_rows[] = $r;
}

$sqlarea = mysql_query("SELECT * FROM `area_table`");
$area_rows = array();
while($r = mysql_fetch_assoc($sqlarea)) {
  $area_rows[] = $r;
}

$sqltype = mysql_query("SELECT * FROM `type_table`");
$type_rows = array();
while($r = mysql_fetch_assoc($sqltype)) {
  $type_rows[] = $r;
}

$result = array();
$result["rooms"] = $room_rows;
$result["areas"] = $area_rows;
$result["types"] = $type_rows;

echo json_encode($result);

?>