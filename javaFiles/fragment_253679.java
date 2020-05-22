for (int i = 0; i < args.length; i+=3)
{
    ICAO = Text.toDouble(args[i+0]);
    t = Text.toDouble(args[i+1]);
    v = Text.toDouble(args[i+2]);
    windChill = Weather.windChillNA(t,v);
    Map.setTemperature(ICAO,windChill);
}