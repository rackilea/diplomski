function showPartitions($prefix, $start, $finish, $numLeft)
{
    if ($numLeft == 0 && $start == $finish) {
        echo $prefix."\n";
    } else {
        $prefix .= "|";
        for ($i = $start + 1; $i <= $finish; $i++) {
            $prefix .= $i.",";
            showPartitions($prefix, $i, $finish, $numLeft - 1);
        }
    }
}