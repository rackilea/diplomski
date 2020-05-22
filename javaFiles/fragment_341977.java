<?php
    $result = file_get_contents("http://nhlwc.cdnak.neulion.com/fs1/nhl/league/teamroster/ANA/iphone/clubroster.json");
    $json = json_decode($result);
    foreach ($json->goalie as $player) {
        echo $player->name . '</br>';
    }
?>