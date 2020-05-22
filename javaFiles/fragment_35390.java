/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computergodzilla.highlighter;

import java.io.File;
import java.io.IOException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.TextFragment;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Example of Lucene Highlighter
 * @author Mubin Shrestha
 */
public class LuceneHighlighter {

    public void highLighter() throws IOException, ParseException, InvalidTokenOffsetsException {
        IndexReader reader = DirectoryReader.open(FSDirectory.open(new File("D:/INDEXDIRECTORY")));
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
        IndexSearcher searcher = new IndexSearcher(reader);
        QueryParser parser = new QueryParser(Version.LUCENE_42, "ncontent", analyzer);
        Query query = parser.parse("going");
        TopDocs hits = searcher.search(query, reader.maxDoc());
        System.out.println(hits.totalHits);
        SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter();
        Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(query));
        for (int i = 0; i < reader.maxDoc(); i++) {
            int id = hits.scoreDocs[i].doc;
            Document doc = searcher.doc(id);
            String text = doc.get("ncontent");
            TokenStream tokenStream = TokenSources.getAnyTokenStream(searcher.getIndexReader(), id, "ncontent", analyzer);
            TextFragment[] frag = highlighter.getBestTextFragments(tokenStream, text, false, 4);
            for (int j = 0; j < frag.length; j++) {
                if ((frag[j] != null) && (frag[j].getScore() > 0)) {
                    System.out.println((frag[j].toString()));
                }
            }
            //Term vector
            text = doc.get("content");
            tokenStream = TokenSources.getAnyTokenStream(searcher.getIndexReader(), hits.scoreDocs[i].doc, "content", analyzer);
            frag = highlighter.getBestTextFragments(tokenStream, text, false, 4);
            for (int j = 0; j < frag.length; j++) {
                if ((frag[j] != null) && (frag[j].getScore() > 0)) {
                    System.out.println((frag[j].toString()));
                }
            }
        }
    }
}