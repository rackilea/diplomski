@Transient
private Long tempUserId;
@Column
private Long changedByUserId;

@PreUpdate
private preUpdate() {
    changed = new Date();
    changedByUserId = tempUserId;
}