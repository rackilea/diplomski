public void setPrimaryMailSender(@Qualifier("primary") JavaMailSender mailSender) {
    this.mailSender = mailSender;
}

public void setSecondaryMailSender(@Qualifier("secondary") JavaMailSender mailSender) {
    this.secondaryMailSender = mailSender;
}