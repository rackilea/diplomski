$user_id=$_REQUEST['user_id'];

$r=mysql_query("select * from tbl_storefinder_pedidos where user_id='$user_id'",$con);

$response= array();
$info=array();
$flag = array();

if( mysql_num_rows( $r ) > 0 ) {
    while($row = mysql_fetch_array($r))
    {
        $flag[pedidos_id]=$row[pedidos_id];
        $flag[pedidos_nome]=$row[pedidos_nome];
        $flag[pedidos_email]=$row[pedidos_email];
        array_push($info, $flag);
    }
        $response["success"] = 1;
        $response["message"] = $info;
        echo json_encode($response);
}
else
{
        $response["success"] = 0;
        $response["message"] = "No entries yet";
        echo json_encode($response);
}