@Enumerated(EnumType.STRING)
@Column(name = "status")
private StatusEnum status = StatusEnum.DRAFT;

public StatusEnum getStatus() {
    return status;
}

public void setStatus(StatusEnum status) {
    this.status = status;
}