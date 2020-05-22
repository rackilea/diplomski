import android.os.AsyncTask;
import android.os.Environment;
import android.util.Base64;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

public class FileSaveThread extends AsyncTask<Socket, Void, DataRecord> {

    @Override
    protected void onPostExecute(DataRecord dataRecord) {
        super.onPostExecute(dataRecord);        
    }

    @Override
    protected DataRecord doInBackground(Socket... sockets) {
        DataRecord dataRecord = null;

        if (isExternalStorageWritable() && sockets.length > 0) {
            Socket socket = sockets[0];
            try {
                Gson gson = new Gson();
                Reader reader = new InputStreamReader(socket.getInputStream());
                SocketObject socketObject = gson.fromJson(reader, SocketObject.class);              

                SaveFileToSDCard(socketObject.Image1, "Image1.png");
                SaveFileToSDCard(socketObject.Image2, "Image2.png");
                SaveFileToSDCard(socketObject.Image3, "Image3.png");

                dataRecord = new DataRecord(socketObject.Name);
            }
            catch (Exception e) { }
            finally {
                try {
                    socket.close();
                } catch (IOException e) { }
            }
        }
        return dataRecord;
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    private void SaveFileToSDCard(String base64String, String fileName) throws IOException {
        byte[] decodedString = Base64.decode(base64String.getBytes(), android.util.Base64.DEFAULT);
        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        fileOutputStream.write(decodedString);
        fileOutputStream.close();
        fileOutputStream.flush();
    }
}