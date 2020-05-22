$str = "java -Xmx1g -jar \"C:\Users\Roxy\Documents\NetBeansProjects\Entity Extraction\dist\Entity Extraction.jar ";

foreach($testArr as $param){
 $str.=$param.' ';
}

exec($str,$output);