<?php

 // generate code
 $code = uniqid();

 // save code to database
 db_save($code);

 // write link
 echo '<a href="download.php?code=' . $code . '">Download</a>';