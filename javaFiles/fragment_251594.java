package org.javachannel.opennlp.example;

import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.stream.Stream;

public class POSTest {
    private void download(String url, File destination) throws IOException {
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(destination);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

    @DataProvider
    Object[][] getCorpusData() {
        return new Object[][][]{{{
                "Can anyone help me dig through OpenNLP's horrible documentation?"
        }}};
    }

    @Test(dataProvider = "getCorpusData")
    public void showPOS(Object[] input) throws IOException {
        File modelFile = new File("en-pos-maxent.bin");
        if (!modelFile.exists()) {
            System.out.println("Downloading model.");
            download("http://opennlp.sourceforge.net/models-1.5/en-pos-maxent.bin", modelFile);
        }
        POSModel model = new POSModel(modelFile);
        PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
        POSTaggerME tagger = new POSTaggerME(model);

        perfMon.start();
        Stream.of(input).map(line -> {
            String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(line.toString());
            String[] tags = tagger.tag(whitespaceTokenizerLine);

            POSSample sample = new POSSample(whitespaceTokenizerLine, tags);

            perfMon.incrementCounter();
            return sample.toString();
        }).forEach(System.out::println);
        perfMon.stopAndPrintFinalResult();
    }
}