@Id  <--------------------------------- remove one of @ID annotation.
@Column(name="kode_korwil", unique=true, nullable=false)
public String getKode_korwil() {
    return kode_korwil;
}

@Id  <--------------------------------- remove one of @ID annotation.
@JoinColumn(name="no_dana")
public String getNo_dana() {
    return no_dana;
}