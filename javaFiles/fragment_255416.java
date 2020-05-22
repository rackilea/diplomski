InputStream is = new FileInputStream(filePath);

int toSkip = 252;
int skipped = 0;

while (toSkip > 0 && (skipped = is.skip(toSkip)) >= 0) {
    toSkip -= skipped;
}