public static OrderStatus getByCodice(int codice) {
    for (OrderStatus tipo : values()) {
        if (tipo.codice == codice) {
            return tipo;
        }
    }
    throw new IllegalArgumentException("Invalid codice: " + codice);
}