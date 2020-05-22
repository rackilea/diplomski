<?php // Examples where a regex solution gets false positives:
    /* PHP multi-line comment with: require('a.php'); */
    // PHP single-line comment with: require('a.php');
    $str = "double quoted string with: require('a.php');";
    $str = 'single quoted string with: require("a.php");';
?>
    <p>HTML paragraph with: require('a.php');</p>