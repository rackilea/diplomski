package textsearch;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextSearch {

    public static void main(final String[] args) throws Exception {

        final URL testFileURL = Thread.currentThread().getContextClassLoader().getResource("textsearch/test.txt");
        final File input = new File(testFileURL.toURI());
        final FileReader reader = new FileReader(input);

        final SearchString search1 = new SearchString("Cell");
        final SearchString search2 = new SearchString("Engine");

        final List<SearchString> searches = new ArrayList<SearchString>();
        searches.add(search1);
        searches.add(search2);

        final Search search = new Search(searches);

        try {
            search.search(reader);
        } finally {
            reader.close();
        }

        if(search.hasPositives()) {
            System.out.print("File " + input.getName() + " contains the words ");
            search.printPositives();
            System.out.println("");
        } else {
            System.out.println("File " + input.getName() + " didn't contain any of the search terms.");
        }

    }

    private static class SearchString {

        final String searchString;
        final ParsePosition pos;

        SearchString(final String searchString) {

            if(searchString == null || searchString.isEmpty())
                throw new IllegalArgumentException("I can't search for nothing!");

            this.searchString = searchString;
            pos = new ParsePosition(0);

        }

        boolean checkNextChar(final char c) {

            if(searchString.charAt(pos.getIndex()) == c) {
                pos.setIndex(pos.getIndex() + 1);
                if(pos.getIndex() >= searchString.length()) {
                    pos.setIndex(0);
                    return true;
                }
                return false;
            } else {
                pos.setIndex(0);
                return false;
            }

        }

        String getString() {

            return searchString;

        }

    }

    private static class Search {

        private final List<SearchString> searches;
        private final List<SearchString> positives;

        Search(final List<SearchString> searches) {

            this.searches = searches;
            positives = new ArrayList<SearchString>();

        }

        void search(final Reader reader) throws IOException {

            int current;

            while((current = reader.read()) != -1 && !searches.isEmpty()) {

                char c = (char)current;

                for(final Iterator<SearchString> it = searches.iterator(); it.hasNext();) {
                    final SearchString searchString = it.next();
                    final boolean matches = searchString.checkNextChar(c);
                    if(matches) {
                        positives.add(searchString);
                        it.remove();
                    }
                }

            }

        }

        boolean hasPositives() {

            return !positives.isEmpty();

        }

        void printPositives() {

            for(final Iterator<SearchString> it = positives.iterator(); it.hasNext();) {
                final SearchString searchString = it.next();
                System.out.print(searchString.getString());
                if(it.hasNext())
                    System.out.print(", ");
            }

        }

    }

}