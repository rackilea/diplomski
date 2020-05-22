byte[] buf = new byte[8192];
int next;
try {
    while ((next = in.read(buf)) != -1) {}
} catch (IOException e) {
    throw new GroovyRuntimeException("exception while dumping process stream", e);
}