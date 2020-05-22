if($id > 0){
    $query = 'update akun set nama = "'.$nama.'", alamat = "'.$alamat.'", noidentitas = "'.$noidentitas.'", notelepon = "'.$notelepon.'", username = "'.$username.'", password = "'.$password.'" where id = '.$id;
    } else {
    $query = 'insert into akun (nama, alamat, noidentitas, notelepon, username, password) values ("'.$nama.'", "'.$alamat.'", "'.$noidentitas.'", "'.$notelepon.'", "'.$username.'", "'.$password.'")';
    }
    $result=mysql_query($query);   
   if ($result) {     // This validates if Query was successful
 echo  '{"success":1,
          "message":"Registered Successfully"}';

} else {
echo  '{"success":2,
          "message":"Registration failed"}';

}