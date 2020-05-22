if (task.isSuccessful()) {
    ...
} else {
    Throwable taskException = task.getException();

    // Before invoking getMessage() on the exception,
    // we make sure the exception is not null
    if (taskException != null) {
        Toast.makeText(Login.this, taskException.getMessage(), Toast.LENGTH_LONG).show();
    }
}