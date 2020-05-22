$dbh = new PDO('mysql:host=localhost;dbname=test', $user, $pass);
$query ='SELECT * FROM post_data WHERE type=:type ORDER BY id DESC LIMIT 15';
$stmt = $dbh->prepare($query);
if ($stmt->execute(array(':type'=>'mixtape'))) {
  $json = array();
  while ($row = $stmt->fetch()) {
    $json[] = $row;
  }
  echo json_encode($row);
}