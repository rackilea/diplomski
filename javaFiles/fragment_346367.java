@PreUpdate
private void preUpdate() {
    edited = LocalDateTime.now();

    if (state != 'A' || state != 'I') {
        state = 'A';
    }
}