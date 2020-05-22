$chaine = <<<EOT
#<COMPTE
[6007](template)
fullname = ggg
username = ggg
secret = nana
COMPTE>#

#<COMPTE
[6008](template)
fullname = dada
username = dada
secret = dada
COMPTE>#
EOT;

$pattern = "/COMPTE(.*?)COMPTE/sm"; // s = dotall, m = multiline
preg_match_all($pattern, $chaine, $matches);
print_r($matches);