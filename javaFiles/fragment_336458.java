require_once 'PHP/Beautifier.php';

// Load the content of my source-file, with missing docblocks
$sourcecode = file_get_contents('MyClass.php');

$oToken = new PHP_Beautifier(); 

// The phpDoc.filter.php file is not in the default directory,
// but in the "current" one => we need to add it to the list of
// directories that PHP_Beautifier will search in for filters
$oToken->addFilterDirectory(dirname(__FILE__));

// Adding some nice filters, to format the code
$oToken->addFilter('ArrayNested');  
$oToken->addFilter('Lowercase');        
$oToken->addFilter('IndentStyles', array('style'=>'k&r'));

// Adding the phpDoc filter, asking it to add a license
// at the beginning of the file
$oToken->addFilter('phpDoc', array('license'=>'php'));

// The code is in $sourceCode
// We could also have used the setInputFile method,
// instead of having the code in a variable
$oToken->setInputString($sourcecode);        
$oToken->process();

// And here we get the result, all clean !              
echo $oToken->get();