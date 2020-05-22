import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    private BufferedReader reader;
    private String line;
    private static final String DOUBLE_QUOTE = "\"";
    private static final String COMMENT_SYMBOL = "#";
    private static final char stateINIT = 'S';
    private static final char stateCOMMENT = '#';
    private static final char stateQUOTED_DATA = 'q';
    private static final char stateQUOTE_IN_QUOTED_DATA = 'Q';
    private static final char stateDATA = 'D';
    private static final char stateNEW_TOKEN = 'N';
    private static final char stateWHITESPACE = 'W';

    public CSVReader(String filename) throws IOException {
        reader = new BufferedReader(new java.io.FileReader(filename));
        loadNextNonCommentLine();
    }

    public ArrayList<String> next() throws IOException {
        if (line == null)
            throw new IOException("Read past end of file");
        ArrayList<String> columns = columnsFromCSVRecord(line);
        loadNextNonCommentLine();
        return columns;
    }

    public boolean hasNext() {
        return line != null;
    }

    void loadNextNonCommentLine() throws IOException {
        do
            line = reader.readLine();
        while (line != null && line.startsWith(COMMENT_SYMBOL));
        if (line == null)
            reader.close();
    }

    public ArrayList<String> columnsFromCSVRecord(String line) throws IOException {
        char state = stateINIT;
        char ch;
        int i = 0;
        ArrayList<String> tokens = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        char[] charArray = line.toCharArray();
        while (i < charArray.length) {
            ch = charArray[i++];
            switch (state) {
            case stateINIT:
                switch (ch) {
                case '"':
                    buffer.append(ch);
                    state = stateQUOTED_DATA;
                    break;
                case ',':
                    state = stateNEW_TOKEN;
                    tokens.add(clean(buffer));
                    buffer = new StringBuffer();
                    break;
                case '\t':
                case ' ':
                    break;
                case '#':
                    state = stateCOMMENT;
                    break;
                default:
                    state = stateDATA;
                    buffer.append(ch);
                    break;
                }
                break;
            case stateCOMMENT:
                break;
            case stateQUOTED_DATA:
                switch (ch) {
                case '"':
                    buffer.append(ch);
                    state = stateQUOTE_IN_QUOTED_DATA;
                    break;
                default:
                    buffer.append(ch);
                    break;
                }
                break;
            case stateQUOTE_IN_QUOTED_DATA:
                switch (ch) {
                case '"':
                    state = stateQUOTED_DATA;
                    break;
                case ',':
                    state = stateNEW_TOKEN;
                    tokens.add(clean(buffer));
                    buffer = new StringBuffer();
                    break;
                case ' ':
                case '\t':
                    break;
                case '#':
                    tokens.add(clean(buffer));
                    state = stateCOMMENT;
                    break;
                default:
                    throw new IOException("badly formed CSV record:" + line);
                }
                break;
            case stateDATA:
                switch (ch) {
                case '#':
                    tokens.add(clean(buffer));
                    state = stateCOMMENT;
                    break;
                case ',':
                    state = stateNEW_TOKEN;
                    tokens.add(clean(buffer));
                    buffer = new StringBuffer();
                    break;
                default:
                    buffer.append(ch);
                    break;
                }
                break;
            case stateNEW_TOKEN:
                switch (ch) {
                case '#':
                    tokens.add(clean(buffer));
                    state = stateCOMMENT;
                    break;
                case ',':
                    tokens.add(clean(buffer));
                    buffer = new StringBuffer();
                    break;
                case ' ':
                case '\t':
                    state = stateWHITESPACE;
                    break;
                case '"':
                    buffer.append(ch);
                    state = stateQUOTED_DATA;
                    break;
                default:
                    state = stateDATA;
                    buffer.append(ch);
                    break;
                }
                break;
            case stateWHITESPACE:
                switch (ch) {
                case '#':
                    state = stateCOMMENT;
                    break;
                case ',':
                    state = stateNEW_TOKEN;
                    // ACCEPT NEW EMPTY COLUMN HERE??
                    break;
                case '"':
                    buffer.append(ch);
                    state = stateQUOTED_DATA;
                    break;
                case ' ':
                case '\t':
                    break;
                default:
                    state = stateDATA;
                    buffer.append(ch);
                    break;
                }
                break;
            default:
                break;
            }
        }
        if (state == stateQUOTED_DATA)
            throw new IOException("Unmatched quotes in line:\n" + line);
        if (state != stateCOMMENT)
            tokens.add(clean(buffer));
        return tokens;
    }

    public String clean(StringBuffer buffer) {
        String string = buffer.toString().trim();
        if (string.startsWith(DOUBLE_QUOTE))
            return string.substring(1, string.length() - 1);
        return string;
    }
}