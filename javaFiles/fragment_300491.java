public class PingReader
{

    static final String pingOut = "    Esecuzione di Ping 10.10.0.161 con 32 byte"
            + " di dati:\n"
            + "Risposta da 10.10.0.161: byte=32 durata=3ms TTL=64\n\n"
            + "Statistiche Ping per 10.10.0.161:\n"
            + "    Pacchetti: Trasmessi = 1, Ricevuti = 1,\n"
            + "    Persi = 0 (0% persi),\n"
            + "Tempo approssimativo percorsi andata/ritorno in millisecondi:\n"
            + "    Minimo = 3ms, Massimo =  3ms, Medio =  3ms";

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        StringReader inReader = new StringReader(pingOut);
        BufferedReader in = new BufferedReader(inReader);
        String inputLine = "";      

        Pattern pattern = Pattern.compile(".*?durata=(.*?)ms ",Pattern.CASE_INSENSITIVE |
                Pattern.MULTILINE | Pattern.DOTALL);               
        Matcher m = null;
        while ((inputLine = in.readLine()) != null) {
                m = pattern.matcher(inputLine);

                if (m.find()) {
                    int sendTime = (Integer.parseInt(m.group(1)));

                           String piii= m.group(1);
                            System.out.println(piii);
                }
        }       
    }
}