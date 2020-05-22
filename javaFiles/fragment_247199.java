<?php
$mysqli = new mysqli("localhost", "root", "", "leoni");

/* Vérification de la connexion */
if (mysqli_connect_errno()) {
    printf("Échec de la connexion : %s\n", mysqli_connect_error());
    exit();
}
/* Recuperer les params passées */
$username = $mysqli->real_escape_string($_POST['PARAM_NAME']);
$password = $mysqli->real_escape_string($_POST['PARAM_PASSWORD']);


 $result =  $mysqli->query("SELECT COUNT(*) FROM agent_sos WHERE nom_prenom ='$username' AND mot_de_passe='$password'");
 $row = $result->fetch_row();
 if($row[0] !=0) {
    printf("true");
}else
    printf("false");

/* Fermeture de la connexion */
$mysqli->close();
?>