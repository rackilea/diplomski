<?php
# ...
# (function stuff)
ob_start();
passthru("php myscript.php, $result");
$content_grabbed=ob_get_contents();
ob_end_clean();

if($result=0){
 echo '<div>',$content_grabbed,'</div>';
}_
# (more function stuff)
# ...
?>