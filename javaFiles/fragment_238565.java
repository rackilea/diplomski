$json = json_decode(file_get_contents('php://input'), true);
$conn = new PDO("mysql:host=$dbhost;dbname=$dbname",$dbuser,$dbpass);
if($json['metodo'] == "inserisciLuogo"){

    $latitudine = $json['latitudine'];
    $longitudine = $json['longitudine'];
    $nome = $json['nome'];
    $indirizzo = $json['indirizzo'];
    $Utente_idUtente = $json['Utente_idUtente'];

    $sql = "INSERT INTO luogo (latitudine, longitudine, nome, indirizzo, Utente_idUtente)
        VALUES (:latitudine, :longitudine, :nome, :indirizzo, :Utente_idUtente)";
    $query = $conn->prepare($sql);
    $query->bindParam(':latitudine', $latitudine, PDO::PARAM_STR);
    $query->bindParam(':longitudine', $longitudine, PDO::PARAM_STR);
    $query->bindParam(':nome', $nome, PDO::PARAM_STR);
    $query->bindParam(':indirizzo', $indirizzo, PDO::PARAM_STR);
    $query->bindParam(':Utente_idUtente', $Utente_idUtente, PDO::PARAM_STR);

    $result = $query->execute();

    if($result)
        echo json_encode(array('risultato' => "1"));
    else
        echo $query->errorCode();
}