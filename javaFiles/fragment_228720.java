StringWriter stringWriter = new StringWriter();
int[] a = {1,2,3,4,5};
String[] b = new String[a.length];
for ( int i = 0; i < a.length; i++) {
    b[i] = a[i];
}
CSVWriter csvWriter = new CSVWriter(stringWriter, ",");
csvWriter.writeNext(b);