public class Test {

    public static String getMovieInfo(String movie) {
        BufferedReader rd;
        OutputStreamWriter wr;
        //Scanner s = new Scanner(System.in);
        //System.out.println("Enter input:");
        //movie = s.nextLine();
        //movie = movie.replaceAll(" ", "%20");
        if (movie != null)
        {
            try {
                URL url = new URL("http://www.imdbapi.com/?i=&t=" + movie);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.flush();

                // Get the response
                rd = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String line = rd.readLine();
                if (line != null) {
                   return line;
                } else {

                    return "Sorry! That's not a valid URL.";
                }
            } catch (UnknownHostException codeyellow) {
                System.err.println("Caught UnknownHostException: " + codeyellow.getMessage());
            }
            catch (IOException e)
            {
                System.out.println("Caught IOException:" + e.getMessage());
            }

        }
        else
        {
            return "passed parameter is null!";
        }

        return "an error occured, see console!";
    }
}