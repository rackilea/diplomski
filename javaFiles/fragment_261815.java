Collection<Collection<String>> emailBatches = Helper.split(emails, 500);
    for (Collection<String> emailBatch : emailBatches) {
        sendEmails(emailBatch);
        // do something else...
        // and something else ...
    }
}