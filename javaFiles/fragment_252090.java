static boolean hasCause(Throwable e, Class<? extends Throwable> cl) {
    return cl.isInstance(e) || e.getCause() != null && hasCause(e.getCause(), cl);
}

catch(ExpException e) {
    if (hasCause(e, UnknownHostException.class)) {
       doSmth();
    } else {
       doSmthElse();
    }
}