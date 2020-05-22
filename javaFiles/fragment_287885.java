// Create connection
$conn = new mysqli("localhost", "root", "", "it210Projekat");

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// set parameters
if(!empty($_POST["send"])) {
$imeKor = $_POST["imeKor"];
$prezimeKor = $_POST["prezimeKor"];
$brojTelefonaKor = $_POST["brojTelefonaKor"];
$godineKor = $_POST["godineKor"];
$emailKor = $_POST["emailKor"];
$izborMotoraKor = $_POST["izborMotoraKor"];
}

// prepare, bind and execute
$stmt = $conn->prepare("INSERT INTO bazarezervisanihvozila (imeKor, prezimeKor,brojTelefonaKor,godineKor, emailKor, izborMotoraKor) VALUES (? , ? , ? , ? , ? , ?)");
$stmt->bind_param("ssiiss", $imeKor, $prezimeKor, $brojTelefonaKor, $godineKor, $emailKor, $izborMotoraKor);
$stmt->execute();



$stmt->close();
$conn->close();
?>