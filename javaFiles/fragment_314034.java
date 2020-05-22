task.setOnFailed(event -> {
    Throwable e = event.getSource().getException();
    if (e instanceof IOException) {
        // handle exception here
    }
});