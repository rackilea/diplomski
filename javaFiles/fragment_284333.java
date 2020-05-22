//Initiate Connection
        $conn = new PDO('mysql:host='.$db_host.';dbname='.$db_name, $db_user, $db_password);

$stmt = $conn->prepare("SELECT password FROM user WHERE username = :username");

if ($stmt->execute(array(':username' => $_POST['username']))) {
    if ($result = $stmt->fetch(PDO::FETCH_ASSOC)) {
        $passwordFromDb = $result['password']; //This is the password you match in password verify. This password should be hashed in the database. if it is hashed it will look something like this - $2y$07$BCryptRequires22Chrcte/VlQH0piJtjXl.0t1XkA8pw9dMXTpOq.
    }
}