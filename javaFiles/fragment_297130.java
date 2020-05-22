$json = file_get_contents('php://input');
 $obj = json_decode($json,true);

 //Database Connection
require_once 'db.php';

 /* insert data into DB */
    foreach($obj as $item) {
       mysql_query("INSERT INTO `database product`.`table name` (productName, productPrice, quantity) 
       VALUES ('".$item['productName']."', '".$item['productPrice']."', '".$item['quantity']."')");

     }
  //database connection close
    mysql_close($con);

   //}