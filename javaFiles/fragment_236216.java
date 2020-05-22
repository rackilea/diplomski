define('HOST','***');
define('USER','***');
define('PASS','***');
define('DB','***');

$con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');

mysqli_set_charset( $con, 'utf8');

$sql = "INSERT INTO users (username, precio, text_cli, l_origen, l_destino, num_pal) VALUES('$user','$precio','$texto','$l_origen','$l_destino','$num_pal')";