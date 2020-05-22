<?php

// get code from url
$single_use_code = $_GET['code'];

// check if the code is in the db
if(db_get_code($single_use_code)) {
   // remove code from database as it is single use only
   db_remove($single_use_code);
   // start download
   start_download();
} else {
   // the code is not valid
   die('BAD code');
}