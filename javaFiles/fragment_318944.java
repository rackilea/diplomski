function file_list($d,$x){
    foreach(array_diff(scandir($d,1),array('.','..')) as $f)if(is_file($d.'/'.$f)&&(($x)?ereg($x.'$',$f):1))$l[]=$f;
    return $l;
}

$arr = file_list("../download/",".zip");

$filename = $arr[0];
$filepath = "http://".$_SERVER['SERVER_NAME']."/download/".$arr[0];
print($filepath);