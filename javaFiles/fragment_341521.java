public class pageDownload {
    public static void down(final String filename, final String urlString)
    throws MalformedURLException, IOException {

        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(new File(filename));

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } catch(FileNotFoundException ex)
        {
            System.err.println("Caught 404: " + e.getMessage());
        }
        catch(IOException ex)
        {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        catch(IndexOutOfBoundsException e)
        {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        finally{
            if(in != null)
                try { in.close(); } catch ( IOException e ) { }
            if(fout != null)
                try { fout.close(); } catch ( IOException e ) { }
        }
    } 
}