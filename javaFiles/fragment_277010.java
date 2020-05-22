$params = array('http' => array(
          'method' => "post",
          'content' => array("field1"=>"data1", "field2"=>"data2")
       ));

$ctx = stream_context_create($params);

$fp = @fopen($urlOfFormSubmission, 'rb', false, $ctx);

if (!$fp)
{
    throw new Error("Problem with ".$urlOfFormSubmission);
}

$contents = @stream_get_contents($fp);

if ($contents === false)
{
    throw new Error("Problem reading data from ".$urlOfFormSubmission);
}