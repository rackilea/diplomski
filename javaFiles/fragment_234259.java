package org.apache.lucene.index;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.codecs.Codec;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.SimpleFSDirectory;

public class GenSegmentInfo {
    public static void main(String[] args) throws IOException {
        Codec codec = Codec.getDefault();
        Path myPath = Paths.get("/tmp/index");
        Directory directory = new SimpleFSDirectory(myPath);

        //launch this the first time with random segmentID value
        //then with java debug, get the right segment ID
        //by putting a breakpoint on CodecUtil#checkIndexHeaderID(...)
        byte[] segmentID = {88, 55, 58, 78, -21, -55, 102, 99, 123, 34, 85, -38, -70, -120, 102, -67};

        SegmentInfo info = codec.segmentInfoFormat().read(directory, "_1rpt",
                segmentID, IOContext.READ);
        info.setCodec(codec);
        SegmentInfos infos = new SegmentInfos();
        SegmentCommitInfo commit = new SegmentCommitInfo(info, 1, -1, -1, -1);
        infos.add(commit);
        infos.commit(directory);
    }
}