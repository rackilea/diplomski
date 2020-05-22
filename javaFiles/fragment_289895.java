rule "ACC STEPS RULE"
when
    accumulate( Steps( $s : steps )
                over window:time( 1h ) from entry-point "entrySteps"; 
        $fst: min( $s ), $lst: max( $s );
        $lst - $fst < 50 )
then
    System.out.println("STEPS RULE: get moving!");
end