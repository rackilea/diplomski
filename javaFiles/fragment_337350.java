$output = array();

while ($row = mysql_fetch_array($data)) {
    $response["post"] = strip_tags($row["post_text"]);
    $response["date"] = date('D M d, Y', $row["post_time"]);

    $output[] = $response;
}
echo json_encode($output);