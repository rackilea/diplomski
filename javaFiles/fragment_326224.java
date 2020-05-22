@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Objects.hashCode(this.NumeroParte);
    result = prime * result + Objects.hashCode(this.descripcion);
    result = prime * result + Double.hashCode(this.monto);
    result = prime * result + this.referencia;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null || getClass() != obj.getClass())
        return false;
    COSTOS other = (COSTOS) obj;
    return (Objects.equals(this.NumeroParte, other.NumeroParte)
         && Objects.equals(this.descripcion, other.descripcion)
         && Double.doubleToLongBits(this.monto) == Double.doubleToLongBits(other.monto)
         && this.referencia == other.referencia);
}