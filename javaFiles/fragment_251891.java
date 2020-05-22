Context context = Context.newInstance(request);
try {
    executeBusinessCode();
} finally {
    context.release();
}