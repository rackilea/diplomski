// create a Chronicle for reading or writing.
 String basePath = TMP + File.separator + "deleteme.ict";
 IndexedChronicle tsc = new IndexedChronicle(basePath);

 // create a handle to excerpts in the chronicle.
 Excerpt excerpt = tsc.createExcerpt();

 // add 1024 entries.
 int counter = 1;
 for (int i = 0; i < 1024; i++) {
        excerpt.startExcerpt(129);
        for (int j = 0; j < 128; j += 8)
            excerpt.writeLong(counter++);
        excerpt.write(-1);
        excerpt.finish();
 }

 // somewhere else read the file
    int counter2 = 1;
    Excerpt excerpt2 = tsc.createExcerpt();
    while (excerpt2.nextIndex()) {
        for (int j = 0; j < 128; j += 8) {
            long actual = excerpt2.readLong();
            long expected = counter2++;
            if (expected != actual)
                assertEquals(expected, actual);
        }
        assertEquals(-1, excerpt2.readByte());
        excerpt2.finish();
    }
    assertEquals(counter, counter2);