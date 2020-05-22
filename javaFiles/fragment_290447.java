private int porta;
private List<PrintStream> clientes;

public Servidor(int porta) {
    this.porta = porta;
    this.clientes = new ArrayList<PrintStream>();
}

public void executa() throws IOException {

    double num1, num2, total = 0.0;
    char opr = '\n';

    ServerSocket servidor = new ServerSocket(this.porta)