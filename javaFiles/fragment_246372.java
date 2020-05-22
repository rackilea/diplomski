//conect to database, create table bool_table, insert data to bool_table.......


$response = array();
$resttt = "SELECT bool1, bool2 FROM bool_table";
$result = mysql_query("$resttt");
if (mysql_num_rows($result) > 0) {

        $result = mysql_fetch_array($result);

        $answer = array();
        $answer["bool1"] = $result["bool1"];            
        $answer["bool2"] = $result["bool2"];
        // success
        $response["success"] = 1;

        $response["answer"] = array();

        array_push($response["answer"], $answer);

        // echoing JSON response
        echo json_encode($response);

    }