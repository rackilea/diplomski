<?php
     $username = $_POST['username'];

        require_once('Connect.php');

     $sql = "select * from account_info where username='$username';";

     $res = mysql_query($sql);
     $num=mysql_num_rows($res);
     if($num>0)
     {
        $result= array();
        while($row=mysql_fetch_array($res))
            array_push($result, array('name'=>$row[1],'phone'=>$row[2]));

            echo json_encode(array("result"=>$result));

     }
     else
     {
        echo "No accounts ";
     }
     mysql_close($conn);
?>