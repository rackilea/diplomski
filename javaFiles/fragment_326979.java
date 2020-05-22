<?php
  if (isset($_POST['col']) && isset($_POST['table']) && isset($_POST['condition'])){
      $columnName= $_POST['col'];
      $tableName = $_POST['table'];
      $condition = $_POST['condition'];


    $dbh=mysql_connect ("localhost", "username", "password") or die('Cannot connect to the database because: ' . mysql_error());
    mysql_select_db ("database_name");

    $sql=mysql_query("select '$columnName' from '$tableName' where '$condition'");

    while($row=mysql_fetch_assoc($sql)) $output[]=$row;
    print(json_encode($output));
    mysql_close();
  }
?>