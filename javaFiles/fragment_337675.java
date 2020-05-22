import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//...
try (BufferedReader in = new BufferedReader(new FileReader("file"));) {
        Map<Integer, String> mapHash = new HashMap<>();
        int i = 0;
        String st;

        while ((st = in.readLine()) != null) {
            st = st.trim();
            StringTokenizer tokenizer = new StringTokenizer(st);
            int j = 0;
            while (tokenizer.hasMoreTokens()) {
                if (j == 1) {
                    mapHash.put(i, tokenizer.nextToken());
                    break;
                } else {
                    tokenizer.nextToken();
                    j++;
                }
            }
            //store the lexicon with position in the hashmap
            i++;
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }