private void runAapt() throws Exception {
    Util.deleteRecursive(new File(S.dirRes, "drawable-xxhdpi"));

    Aapt aapt = new Aapt();
    int exitCode = aapt.fnExecute("aapt p -f -v -M " + S.xmlMan.getPath() + " -F " + S.ap_Resources.getPath()
            + " -I " + S.jarAndroid.getPath() + " -A " + S.dirAssets.getPath() + " -S " + S.dirRes.getPath()
            + " -J " + S.dirGen.getPath());

    if (exitCode != 0) {
        throw new Exception("AAPT exit(" + exitCode + ")");
    }
}