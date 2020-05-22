$entries = $msg->map['map'][0]['entry'];
$map = array();
foreach($entries as $entry) {
    $vals = array_values($entry);
    if(count($vals) == 1 && is_array($vals[0])) {
        $vals = $vals[0];
    }
    $map[$vals[0]] = $vals[1];
}