public class GoogleDistanceMatrixConnection
{

    public String makeXMLFile(String start, String end) throws IOException
    {
        return "http://maps.googleapis.com/maps/api/distancematrix/xml?origins=" + URLEncoder.encode(start) +"&destinations=" + URLEncoder.encode(end) +"&language=en-EN&sensor=false&language=en-EN&units=imperial";    
    }
}