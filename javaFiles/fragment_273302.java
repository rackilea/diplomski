//store # of rows returned
$num_rows = mysql_num_rows($query);

if ($num_rows >= 1) {
    $output = array();

    while($results = mysql_fetch_assoc($query)) {
        // append row to output
        $output[] = results
    }

    mysql_close();  // shouldn't that be outside the if block?

    //encode the returned data in JSON format
    echo json_encode($output);
}