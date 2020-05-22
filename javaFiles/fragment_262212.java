public boolean equals(Object obj) {
    if (obj==null || obj.getClass()!=this.getClass())
        return false;
    if (obj==this)
        return true;
    Alpha guest = (Alpha)obj;
    return guest.getLocal().equals(this.getLocal())
            && guest.getCompany().equals(this.getCompany())
            && guest.getTitle().equals(this.getTitle());
}