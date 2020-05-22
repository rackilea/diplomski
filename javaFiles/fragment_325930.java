@Override
public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (!(obj instanceof IRepositorio))
      return false;
    return ((ReferenceData) obj).getCode().equals(this.code);
}