try {
    reader = new PdfReader(thepdffilename);
} catch (IOException e) {
    openok=false;
} catch (NullPointerException npe) { // !!
    openok=false;                    // !!
}