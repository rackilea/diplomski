$sql = mysqli_query("SELECT ...");
$resluts = array();
while($row = mysqli_fetch_assoc($sql)) {
    $tmp = array();
    $tmp["id"] = $row["id"];
    $tmp["user"] = $row["user"];
    $tmp["highscore"] = $row["highscore"];
    array_push($results["Results"], $tmp);
}
echo json_encode($results);