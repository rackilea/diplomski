<?php

$yui1 = "SELECT photodirectory FROM photos WHERE photoowner= $userid ";
$result = mysqli_query($connDirectory, $yui1);
echo "rquery1 is equal to: ";
var_dump($result);
echo "</br>";

if (mysqli_num_rows($result) > 0) {
    // output data of each row
    while($row = mysqli_fetch_assoc($result)) {
        echo '<img src="../' . $row["photodirectory"] . '">' . "</br>";
    }
} else {
    echo "0 results";
}

?>