// keep highlighted entries in sequence
$highlights = [];

foreach ($hits as $doc) {
    // if we have a highlighting element for this document
    if (!empty($result['highlighting'][$doc['id']])) {
        // keep the highlighted text
        $highlights[] = $result['highlighting'][$doc['id']];
    } else {
        // .. and if we don't, add a null element so indices match
        $highlights[] = null; 
    }
}