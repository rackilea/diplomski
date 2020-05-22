public void printDifferences(COSTOS other) {
    if (! Objects.equals(this.NumeroParte, other.NumeroParte))
        System.out.println("Different NumeroParte: " + this.NumeroParte + " != " + other.NumeroParte);
    if (! Objects.equals(this.descripcion, other.descripcion))
        System.out.println("Different descripcion: " + this.descripcion + " != " + other.descripcion);
    if (Double.doubleToLongBits(this.monto) != Double.doubleToLongBits(other.monto))
        System.out.println("Different monto: " + this.monto + " != " + other.monto);
    if (this.referencia != other.referencia)
        System.out.println("Different referencia: " + this.referencia + " != " + other.referencia);
}