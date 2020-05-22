public String updation() {
    try {
        // do stuff...
        return SUCCESS;
    } catch (NumberFormatException e) {
        addActionError("Errors... ");
        e.printStackTrace();
        return ERROR;
    }
}