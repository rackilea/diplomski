<?php
  $receivedObject = json_decode($_POST['data'], true);
  $name = $receivedObject['firstName'];
  $lastName = $receivedObject['lastName'];
  echo $name . ' ' . $lastName;
?>