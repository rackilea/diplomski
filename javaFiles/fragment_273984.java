} else {
    // Here I am doing the update of my progress bar
    Log.v("Decompress", "more " + ze.getName());

    per++;
    publishProgress(per);

    FileOutputStream fout = new FileOutputStream(_location + ze.getName());

    streamCopy(zin, fout);

    zin.closeEntry();
    fout.close();
}