public class GUDPClient {

    private int PORT_NUMBER = 4444; // Nº de puerto de conexión. Usamos el mismo para Servidor y Cliente (para no liar)

    private DatagramSocket clientSocket; // Socket Cliente
    private DatagramPacket inPacket; // Paquete de entrada
    private DatagramPacket outPacket; // Paquete de salida

    private InetAddress host; // Dirección IP del Servidor (LG L5)
    public static final String IP_LG = "192.168.1.102"; // IP del Servidor (LG L5)
    public static final String IP_TABLET = "192.168.1.105"; // IP del Servidor (Tablet)

    /**
     * Constructor.
     */
    public GUDPClient() {
        try {
            clientSocket = new DatagramSocket(); // No hace falta darle un nº de puerto (se lo damos al paquete)
            host = InetAddress.getByName(IP_LG); // Obtenemos el host del Servidor (LG L5)
            //host = InetAddress.getByName(IP_TABLET); // Obtenemos el host del Servidor (Tablet)

            System.out.println("Cliente UDP conectado.");
        } catch (SocketException e) {
            System.out.println("Socket: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: "+e.getMessage());
        }
    } // GUDPClient()

    /**
     * Envía (escribe) un buffer de bytes por UDP.
     * @param buffer - La memoria intermedia donde se almacenan los datos a enviar.
     */
    public void write(byte[] buffer) {
        outPacket = new DatagramPacket(buffer, buffer.length, host, PORT_NUMBER);

        try {
            clientSocket.send(outPacket); // Enviamos el paquete por UDP
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // write()

    /**
     * Recibe (lee) un buffer de bytes por UDP.
     * @param buffer - La memoria intermedia donde se almacenan los datos a recibir.
     */
    public void read(byte[] buffer) {
        inPacket = new DatagramPacket(buffer, buffer.length);

        try {
            clientSocket.receive(inPacket); // Recibimos el paquete procesado desde UDP
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // read()

    /**
     * Cierra la conexión.
     */
    public void stop() {
        if (clientSocket != null) {
            clientSocket.close();
        }
    } // stop()

} // GUDPClient