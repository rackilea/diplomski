@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Sickness_Id")
public Sickness getSickness() {
    return this.sickness;
}

public void setSickness(Sickness sickness) {
    this.sickness = sickness;
}