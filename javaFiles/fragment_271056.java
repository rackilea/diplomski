<?php
    /**
     * Define POST URL and also payload
     */
    define('XML_PAYLOAD', '<?xml version="1.0"?><member><name>name</name></member>');
    define('XML_POST_URL', 'http://www.domain.com/build_xml.php');

    /**
     * Initialize handle and set options
     */
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, XML_POST_URL);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_TIMEOUT, 4);
    curl_setopt($ch, CURLOPT_POSTFIELDS, XML_PAYLOAD);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array('Connection: close'));

    /**
     * Execute the request and also time the transaction
     */
    $start = array_sum(explode(' ', microtime()));
    $result = curl_exec($ch);
    $stop = array_sum(explode(' ', microtime()));
    $totalTime = $stop - $start;

    /**
     * Check for errors
     */
    if ( curl_errno($ch) ) {
        $result = 'ERROR -> ' . curl_errno($ch) . ': ' . curl_error($ch);
    } else {
        $returnCode = (int)curl_getinfo($ch, CURLINFO_HTTP_CODE);
        switch($returnCode){
            case 404:
                $result = 'ERROR -> 404 Not Found';
                break;
            default:
                break;
        }
    }

    /**
     * Close the handle
     */
    curl_close($ch);

    /**
     * Output the results and time
     */
    echo 'Total time for request: ' . $totalTime . "\n";
    echo $result;  

    /**
     * Exit the script
     */
    exit(0);
?>