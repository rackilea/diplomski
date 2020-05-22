//Get the request body
$inputJSON = file_get_contents('php://input');
//Convert into array
$input = json_decode($inputJSON, TRUE);

$username = $input['username'];
$password = $input['password'];