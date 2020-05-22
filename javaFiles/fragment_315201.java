@Column(...)
public Date getCreated() {
    return created;
}

@Transient
public boolean isCreated() {
    return isStatus(StatusType.CREATED);
}