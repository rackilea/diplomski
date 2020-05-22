//Make an array to collect the results
$rows = array();
while ($row = $stmt->fetch()) {
       //add the results to the array
       $rows[] = $col1;
   }
//print the object:
echo json_encode($rows);