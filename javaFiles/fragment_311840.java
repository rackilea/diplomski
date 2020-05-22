BufferedReader br = getBufferedReader(inputStream);
setInfosProcess(null);
char[] cbuf = new char[1024]; // Adjust the length of the array to suit your needs.
StringBuilder outputBuilder = new StringBuilder();
try {
    while ((StrInprocess = br.read(cbuf)) != -1) {
         outputBuilder.append(cbuf); // You will get the "Press Any Key" text as soon as it appears.
         // Whatever you want to do here with the outputBuilder object...
    }
}