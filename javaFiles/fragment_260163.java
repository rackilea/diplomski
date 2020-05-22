private void processScript( InputStream script, String chunkname, OutputStream out ) throws IOException {
    try {
        // create the chunk
        Prototype chunk = LuaC.instance.compile(script, chunkname);

        // list the chunk
        if (list)
            Print.printCode(chunk);

        // write out the chunk
        if (!parseonly) {
            DumpState.dump(chunk, out, stripdebug, numberformat, littleendian);
        }

    } catch ( Exception e ) {
        e.printStackTrace( System.err );
    } finally {
        script.close();
    }
}