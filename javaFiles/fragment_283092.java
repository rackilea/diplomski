// not transactional
public void process() {
    beanB.updateDatabase();
    sendEmail();
}

private void sendEmail() {
    ...
}