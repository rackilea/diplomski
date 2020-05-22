File outDir = new File("Out")

/* You will probably need something more complicated than
 * this (to delete the directory's contents first). I'd
 * suggest using FileUtils.deleteDirectory(dir) from
 * Apache Commons-IO.
 */
outDir.delete();

// Prove that it's not there
assertFalse(outDir.exists());

createReport(...);

// Prove that it has been created
assertTrue(outDir.exists());