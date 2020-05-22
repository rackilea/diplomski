<?php 
    $bigArray = array();

    for ($x = 0; $x <= 10; $x++) {
            $product = array();
            $product["sgroup"] = $x;
            $product["service"] = $x;
            $product["code"] = $x;
            $product["value"] = $x;
            $product["updated_at"] = $x;

            array_push($bigArray, $product);
        }
      // echoing JSON response
      echo json_encode($bigArray);      
?>