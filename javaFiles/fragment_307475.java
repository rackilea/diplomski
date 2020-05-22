if(isset($_GET['idcmd']))
{
    switch($_GET['idcmd'])
    {
        case 1:
                if(isset($_POST['iduser']))
                {
                    $sql= "SELECT idUser FROM users WHERE idUser=:iduser ";
                    $result = $db_conn->prepare($sql);
                    $result->bindParam(":iduser" ,$_POST['iduser']);
                    $result->execute();

                    $num=$result->fetchColumn();
                    if($num > 0){
                        echo "cool";
                    }else{
                        echo "nocool";
                    }
                }
        break;
    }
}