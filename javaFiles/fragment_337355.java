import com.icafe4j.io.RandomAccessInputStream;
import com.icafe4j.io.FileCacheRandomAccessInputStream;
import com.icafe4j.util.FileUtils;

public class TestTIFFTweaker {

    public static void main(String[] args) throws Exception {
        FileOutputStream fin = new FileInputStream(args[0]);
        RandomAccessInputStream rin = new FileCacheRandomAccessInputStream(fin);
        TIFFTweaker.splitPages(rin, FileUtils.getNameWithoutExtension(new File(args[0])));
        rin.close();
        fin.close(); // Need to close the underlying stream explicitly!!!
    }
}