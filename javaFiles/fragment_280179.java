@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CcustoPrestadorOuImplDTO that = (CcustoPrestadorOuImplDTO) o;
    return Objects.equals(cdCcusto, that.cdCcusto) &&
            Objects.equals(deCcusto, that.deCcusto) &&
            Objects.equals(grupoOperativo, that.grupoOperativo) &&
            Objects.equals(deGrupoOperativo, that.deGrupoOperativo);
}