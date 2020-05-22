$myfile = '/my/jar/file.jar';

$zip = new ZipArchive();
$res = $zip->open($myfile, ZipArchive::CHECKCONS);
if ($res !== TRUE) {
    switch($res) {
        case ZipArchive::ER_NOZIP:
            die('not a zip archive');
        case ZipArchive::ER_INCONS :
            die('consistency check failed');
        case ZipArchive::ER_CRC :
            die('checksum failed');
        default:
            die('error ' . $res);
    }
}