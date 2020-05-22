String [] parts = ssid.split("-");

if(parts.length == 2)
{

    String firstPart = parts[0]; //That's KD
    String secondPart = parts[1]; //That's 435

    if(firstPart.equals("KD")&&Integer.parseInt(secondPart)>=400&&Integer.parseInt(secondPart)<=500)
    {
    //do whatever you want
    }
}