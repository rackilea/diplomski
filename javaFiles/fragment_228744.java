public class GUDPServer_A {

    private int PORT_NUMBER = 4444; // Nº de puerto de conexión. Usamos el mismo para Servidor y Cliente (para no liar)

    private DatagramSocket serverSocket; // Socket Servidor
    private DatagramPacket inPacket; // Paquete de entrada
    private DatagramPacket outPacket; // Paquete de salida

    private boolean running = true; // Booleano para indicar que se está a la escucha del Cliente

    // Buffers:
    public static final int BUFFER_SIZE = 1024 * 4;
    public static byte[] bytes_in;
    public static byte[] bytes_out;

    public GUDPServer_A() {
        bytes_in = new byte[BUFFER_SIZE];
        bytes_out = new byte[BUFFER_SIZE];
        try {
            serverSocket = new DatagramSocket(PORT_NUMBER); // Sólo se hace una vez ya que siempre estamos mandando por el mismo puerto
            System.out.println("Servidor UDP en marcha.");
        } catch (SocketException e) {
            System.out.println("Socket: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: "+e.getMessage());
        }
    } // GUDPServer_A()

    /**
     * Ejecución del hilo. El método no está sobreescrito porque usamos una subclase (connectTask) que extiende de AsyncTask.
     */
    public void run() {
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_URGENT_AUDIO); // Le damos prioridad "-19" al Thread (Lo máximo es -20)

        int lap = 0; // Para llevar la cuenta de las vueltas
        while (running) { 
            read(bytes_in); // Recibimos el paquete desde UDP

            // Procesamos (de momento lo dejamos igual, simplemente clonamos):
            bytes_out = bytes_in.clone();

            G.toc = System.currentTimeMillis();
            G.ticToc();
            G.tic = G.toc;

            write(bytes_out); // Enviamos el paquete de vuelta

            Log.d("Vuelta:", ""+lap);
            lap++;
        }
    } // run()

    /**
     * Envía (escribe) un buffer de bytes por UDP.
     * @param buffer - La memoria intermedia donde se almacenan los datos a enviar.
     */
    public void write(byte[] buffer) {
        outPacket = new DatagramPacket(buffer, inPacket.getLength(), inPacket.getAddress(), inPacket.getPort());

        try {
            serverSocket.send(outPacket); // Enviamos el paquete
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
            serverSocket.receive(inPacket); // Recibimos el paquete
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // read()

    /**
     * Cierra la conexión.
     */
    public void stop() {
        if (serverSocket != null) {
            serverSocket.close();
        }
    } // stop()

} // GUDPServer_A