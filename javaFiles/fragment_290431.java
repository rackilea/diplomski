if (numero > 99 || numero < limite_inferior) {
    this.numero = limite_inferior;
    limite_inferior++;
}

this.numero = numero; //HERE