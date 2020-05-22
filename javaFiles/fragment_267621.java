import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.FSDirectory;

public class IndexCreator {

    public static IndexWriter getWriter() throws IOException{
          File indexDir = new File("D:\\Experiment");
          SimpleAnalyzer analyzer = new SimpleAnalyzer();
          IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
          indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
          IndexWriter indexWriter = new IndexWriter(FSDirectory.open(indexDir
                .toPath()), indexWriterConfig);
          indexWriter.commit();
          return indexWriter;

    }
}