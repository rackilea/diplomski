InputStream in = ...
BufferedReader reader = new BufferedReader(new InputStreamReader(in));
String line = null;
int idx = 0;
int blockIdx = 0
while ((line = in.readLine()) != null) {
    if (idx % 100 == 0) {
        blockIdx++;
    }
    idx++;
}