rule "ACC STEPS RULE"
when
  Walker( $mac: macAddress )
  accumulate( Steps( $s : steps, macAddress == $mac )
              over window:time( 1h ) from entry-point "entrySteps"; 
      $fst: min( $s ), $lst: max( $s );
      $lst - $fst < 50 )
  then ... end