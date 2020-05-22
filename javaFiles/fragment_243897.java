$text = 'This text is about my wish to test it';
$words = explode(' ', $text);
$wordsCount = count($words);

for ($i = 0; $i < $wordsCount; $i++) {
    $window = 2;
    $windowEnd = 5;
    if ($i + $windowEnd > $wordsCount) {
        $windowEnd = $wordsCount - $i;
    }
    if ($windowEnd < $window) {
        break;
    }
    while ($window <= $windowEnd) {
        for ($j = $i; $j < $i + $window; $j++) {
            echo $words[$j], "\n";
        }
        echo "\n";
        $window++;
    }
}