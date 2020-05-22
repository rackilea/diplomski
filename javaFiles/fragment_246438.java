<?php

    $pass = 'MySecretP@55';
    $hashed = hash("SHA512", $pass);
    echo $hashed;
    echo '<hr>' . bin2hex($hashed);

?>