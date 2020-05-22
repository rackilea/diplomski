<?php

    require("config.inc.php");

    try {
        $result = $db->query("SELECT COUNT(*) FROM first1000");
        $row = $result->fetch();
        $nbUsers = $row["COUNT(*)"];
    }
    catch (PDOException $ex) {
        $response = "Database Error.";
        die(json_encode($response));
    }

    if ($nbUsers < 1000) {
        $query = "INSERT INTO first1000 (id) VALUES (DEFAULT)";

        try {
            $stmt   = $db->prepare($query);
            $result = $stmt->execute();
        }
        catch (PDOException $ex) {
            $response = "Database Error.";
            die(json_encode($response));
        }

        $response = first1000yes;
        echo $nbUsers;
        echo json_encode($response);
    }
    else {
        $response = first1000no;
        echo json_encode($response);
    }

?>