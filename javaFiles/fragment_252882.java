public void setDOB(Date DOB) throws PersonException {

    if (((new Date()).getYear() + 1900) > DOB.getYear() + 100) {
            throw new PersonException(this);
    }
    else {
        this.DOB = DOB;
    }
}