public bool retirar(double valor)
{
    if (valor <= 0) {
        System.out.println("O valor precisa ser positivo");
    }
    else {
        if (saldo < valor) {
            System.out.println("Valor insuficiente");
        }
        else {
            saldo -= valor;
            return true;
        }
        return false;
    }
}