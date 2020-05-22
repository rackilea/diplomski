File fi = new File(Environment.getExternalStorageDirectory().toString() + "/ECG/I.txt");  
scanner = new Scanner(fi);
scanner.useDelimiter(";");

int SAMPLE_SIZE = 4;
double timi[] = new double[SAMPLE_SIZE];

for(int sampleIdx = 0; scanner.hasNext();){
    timi[sampleIdx++] = scanner.nextDouble();
    Log.i("File", "String " + sampleIdx + " " + timi[sampleIdx]);
    if(sampleIdx == SAMPLE_SIZE){
        // Do something with the timi array here.

        sampleIdx = 0;
    }
}