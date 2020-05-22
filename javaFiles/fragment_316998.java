public bool retirarDe(int numeroConta, double valor) {
    for (int i =0; i<numContas; i++) {
        if (numeroConta == contas[i].getNumeroConta()) {
            bool suficiente = contas[i].retirar(valor);
            if (suficiente) {
                System.out.println("Valor retirado com sucesso");
            }
            else
            {
                System.out.println("Salido insuficiente");
            }
        return suficiente;
        }
    }
    System.out.println("Número de conta inválido.");
}