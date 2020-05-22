public function insert_multi($table, $items) {
    $query = mysqli_query($this->connect,
        "INSERT INTO `$table` (`firstKeyName`, `secondKeyName`) ".
        "VALUES ('".$items['firstKeyName']."', '".$items['secondKeyName']."')");

        if ($query == true)
        {
            return true;
        }
        else{
            return false;
        }
    }