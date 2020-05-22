import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

public class Downloader {

    public static final int BUFFER = 2048;

    private void download(String surl, String pathToSave) throws IOException {
        URL url = new URL(surl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try (InputStream stream = con.getInputStream()) {
            Files.copy(stream, Paths.get(pathToSave));
        }
    }

    private void unGz(String pathToGz, String outputPath) throws IOException {
        FileInputStream fin = new FileInputStream(pathToGz);
        BufferedInputStream in = new BufferedInputStream(fin);
        try (FileOutputStream out = new FileOutputStream(outputPath)) {
            try (GzipCompressorInputStream gzIn = new GzipCompressorInputStream(in)) {
                final byte[] buffer = new byte[BUFFER];
                int n = 0;
                while (-1 != (n = gzIn.read(buffer))) {
                    out.write(buffer, 0, n);
                }
            }
        }
    }

    public void unTarGz(String pathToTar, String outputPath) throws IOException {
        File tarFile = new File(pathToTar);
        TarArchiveInputStream tarInput
                = new TarArchiveInputStream(new GZIPInputStream(new FileInputStream(tarFile)));

        TarArchiveEntry currentEntry;
        while ((currentEntry = tarInput.getNextTarEntry()) != null) {
            if (currentEntry.isDirectory()) {
                File f = new File(outputPath + currentEntry.getName());
                f.mkdirs();
            } else {
                int count;
                byte data[] = new byte[BUFFER];
                try (FileOutputStream fos = new FileOutputStream(outputPath
                        + currentEntry.getName())) {
                    try (BufferedOutputStream dest = new BufferedOutputStream(fos,
                            BUFFER)) {
                        while ((count = tarInput.read(data, 0, BUFFER)) != -1) {
                            dest.write(data, 0, count);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Downloader down = new Downloader();
        down.download("https://wordpress.org/latest.tar.gz", "/tmp/latest.tar.gz");
        down.unTarGz("/tmp/latest.tar.gz", "/tmp/untar/");
    }
}