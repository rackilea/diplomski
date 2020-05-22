public String getStatusPaciente() {
    if (status == null) {
        return null;
    }
    return status.getStatus();
}