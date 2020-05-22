import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class Test {
    public static void main(String[] args) throws Exception {
        PNGTranscoder t = new PNGTranscoder();
        t.addTranscodingHint(PNGTranscoder.KEY_WIDTH, new Float(12600));
        t.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, new Float(12600));
        FileInputStream fis = new FileInputStream("C:\\StackOverflow\\SVG-logo.svg");
        TranscoderInput input = new TranscoderInput(fis);
        OutputStream ostream = new FileOutputStream("C:\\StackOverflow\\res.png");
        TranscoderOutput output = new TranscoderOutput(ostream);

        System.out.println("AllocatedMemory: \t" + (Runtime.getRuntime().totalMemory() / 1024) + " Kb");
        t.transcode(input, output);
        System.out.println("AllocatedMemory: \t" + (Runtime.getRuntime().totalMemory() / 1024) + " Kb");

        ostream.flush();
        ostream.close();

    }
}