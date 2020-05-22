$Json = array(
    array('test' => '1', 'message' => 'try it'), 
    array('test' => '2', 'message' => 'try it')
  );
$final = array(
  'error' => '1', 
  'json' => $Json
);
die(json_encode($final, JSON_FORCE_OBJECT));