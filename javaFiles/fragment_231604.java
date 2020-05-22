$req;
if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $req = $_GET;
}else {
    $req = $_POST;
}