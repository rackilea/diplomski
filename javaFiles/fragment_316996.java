public void transferir(int numeroContaDe, int numeroContaA, double valor)
{
    bool suficiente = RetirarDe(numeroContaDe, valor);
    if (suficiente) {
        DepositaEm(numeroContaA, valor);
    }
}