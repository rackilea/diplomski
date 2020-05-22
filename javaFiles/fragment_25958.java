int[] vers = new int[2];
GLES30.glGetIntegerv(GLES30.GL_MAJOR_VERSION, vers, 0);
GLES30.glGetIntegerv(GLES30.GL_MINOR_VERSION, vers, 1);
if (vers[0] > 3 || (vers[0] == 3 && vers[1] >= 1)) {
    // We have at least ES 3.1.
}