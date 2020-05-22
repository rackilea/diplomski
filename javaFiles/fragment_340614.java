public abstract class Downloader {
    protected abstract void processLine(String[] line);
    protected abstract void save();
    protected abstract String file();
public void downloadPendingPoleInspections() {

    int count;
    String filePath;

    filePath = Environment.getExternalStorageDirectory() + File.separator + file();

    try {

        downloadFile("http://localhost/api/inspectionservices.aspx?o=retrieve", "pending" + file(), POST_PENDING_INSPECTIONS_PROGRESS_UPDATE);

        int totalInspections = getLineCount(filePath);

        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        int i = 0;
        int j = 0;


        while ((line = br.readLine()) != null) {
            processLine(line.split(" "));
            i++;
            j++;

            if (i >= 2000) {
                save()
                i = 0;                  
            }
        }

        if (i > 0) {
            save()
        }

        br.close();
        file.delete();

    } catch (Exception e) {
        Log.e("SyncActivity", e.toString());            
    }       
}