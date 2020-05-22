Future<?> f = scheduledExecutor.scheduleAtFixedRate(new Log(),...);
try {
    f.get();
} catch (ExecutionException e) {
    Throwable actualException = e.getCause();
}