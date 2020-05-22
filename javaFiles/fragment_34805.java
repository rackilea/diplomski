<?php

define('DB_USER', "*******"); // db user
define('DB_PASSWORD', "*******"); // db password 
define('DB_DATABASE', "*******"); // database name
define('DB_SERVER', "localhost"); // db server

class DB_CONNECT {

function __construct() {
    $this->connect();
}

function __destruct() {
    $this->close();
}

function connect() {

    $con = mysql_connect(DB_SERVER, DB_USER, DB_PASSWORD) or die(mysql_error());

    $db = mysql_select_db(DB_DATABASE) or die(mysql_error()) or die(mysql_error());

    return $con;
}


function close() {
    mysql_close();
}

}

?>