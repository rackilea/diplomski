import tokyocabinet.HDB;

....

String dir = "/path/to/my/dir/";
HDB hash = new HDB();

// open the hash for read/write, create if does not exist on disk
if (!hash.open(dir + "unigrams.tch", HDB.OWRITER | HDB.OCREAT)) {
    throw new IOException("Unable to open " + dir + "unigrams.tch: " + hash.errmsg());
}

// Add something to the hash
hash.put("blah", "my string");

// Close it
hash.close();