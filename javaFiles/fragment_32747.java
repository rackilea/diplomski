ob_start('my_callback');

function my_callback($str) {
  // do something
  return $str;
}