<?php

if (isset($_REQUEST['image'])) {
   ... your decoding/fopen/fwrite stuff here ...
}

header('Content-type: image/jpeg')
readfile('test.jpg');