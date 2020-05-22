$matches = 13;
$outcomes = 3;
$possibilities = $outcomes ** $matches;

for ($count = 0; $count < $possibilities; $count++) {
  echo str_pad(base_convert($count, 10, 3), $matches, '0', STR_PAD_LEFT)."\n";
}