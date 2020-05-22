try {
    message = inbox.getMessage(i);
    // moved all of my calls to message.getFrom(),
    // message.getAllRecipients(), etc. inside this try/catch.
} catch (OutOfMemoryError e) {
    if (firstTry) {
        i--;
        firstTry = false;
    } else {
        firstTry = true;
        System.out.println("Message " + i + " skipped.");
    }
    inbox.close(false);
    System.gc();
    inbox.open(Folder.READ_ONLY);
    continue;
}
firstTry = true;