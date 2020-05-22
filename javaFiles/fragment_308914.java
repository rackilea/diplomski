$strings = <<< LOL
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr-CA" xml:lang="fr-CA">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-AU" xml:lang="en-AU">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-GB" xml:lang="en-GB">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-IE" xml:lang="en-IE">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es-PR" xml:lang="es-PR">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US" xml:lang="en-US">
LOL;

$strings = preg_replace('/(lang=".*?"|xml:lang=".*?")/', '', $strings);

echo $strings;