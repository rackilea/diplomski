if (data.contains("PE846")){   // The string does contain PE846, per your question
    soundString += "engine";   // soundString = "" + "engine" = "engine"
    betaString = "Engine : ";  // betaString = "Engine : "
    sign = engine;             // sign = engine
}
if (data.contains("A846")){    // The string does contain A846, per your question
    soundString += "ambo";     // soundString = "engine" + "ambo"
    betaString += "Ambo : ";   // betaString = "Engine : " + "Ambo : " = "Engine : Ambo : "
    sign = ambo;               // sign = ambo (overwriting the previous value, "engine")
}
if (data.contains("MD846")){   // The string does not contain MD846, per your question
    soundString += "medic";    // not executed
    betaString += "Medic";     // not executed
    sign = medic;              // not executed
}

log.info(betaString + " Alerted");  // betaString + " Alerted" => "Engine : Ambo : Alerted"
{
    new AudioPlayer("sounds/"+ soundString +".wav").start();
    log.info(soundString);          // soundString => "engineambo"
}