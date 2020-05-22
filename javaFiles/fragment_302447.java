$counter = 0;
// read them back
$result = mysql_query( "SELECT * FROM locations" );
echo '[';
while( $data = mysql_fetch_assoc($result) ) {
if (&counter >= 1){
  echo ',';
}
$latFromDb = $data['latitude'];
$longFromDb = $data['longitude'];
$variable = array( 'lon'.$counter => "$longFromDb", 'lat'.$counter => "$latFromDb" );
    // One JSON for both variables
echo json_encode($variable);
$counter++;
}
echo ']';