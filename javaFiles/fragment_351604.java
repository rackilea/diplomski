$aOutput = array('iActualJoinRequests' => $iActualJoinRequests, 'jaPassengers' => '');
    $joOutput = json_encode($aOutput, JSON_FORCE_OBJECT);
    $joOutput = json_decode($joOutput);
    $joOutput -> jaPassengers = $aPassengers;
    $joOutput = json_encode($joOutput);
    echo $joOutput;