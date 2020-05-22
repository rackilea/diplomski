$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$stmt = $conn->prepare("INSERT INTO uploads (username, filename)
VALUES (?,?)";

$stmt->bind_param("ss", $android_username, $file_name);

$stmt->execute();
$stmt->close();
$conn->close();