ProcessBuilder processbuilder
try 
{
    processbuilder.directory(file);
    processbuilder.redirectErrorStream(true);

    process = processbuilder.start();

    String readLine;
    BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
    // include this too: 
    // BufferedReader output = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    while((readLine = output.readLine()) != null)
    {
        m_Logger.info(readLine);
    }

    process.waitFor();
}