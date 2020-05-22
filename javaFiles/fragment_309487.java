import java.util.HashMap;
import java.util.Map;

public class PatternBuilder {

    protected Map<Character, String> mappings = new HashMap<Character, String>();
    protected boolean caseSensitive = false;

    public PatternBuilder() {
    }

    public PatternBuilder(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public PatternBuilder addDefinition(char input, String mapping) {
        if (this.caseSensitive) {
            this.mappings.put(input, mapping);
        } else {
            this.mappings.put(Character.toLowerCase(input), mapping);
        }
        return this;
    }

    public String buildRegexPattern(String mask) {
        if ((mask == null) || (mask.length() == 0))  {
            return "";
        }
        StringBuilder patternBuffer = new StringBuilder();
        char lastChar = 0;
        int count = 0;
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (this.caseSensitive == false) {
                c = Character.toLowerCase(c);
            }
            if (c != lastChar) {
                if (count > 0) {
                    String mapped = mappings.get(lastChar);
                    if (mapped == null) {
                        // mapping for char not defined
                        return "";
                    }
                    patternBuffer.append(mapped);
                    patternBuffer.append("{").append(count).append("}");
                }
                lastChar = c;
                count = 1;
            } else {
                count++;
            }
        }
        if (count > 0) {
            String mapped = mappings.get(lastChar);
            if (mapped == null) {
                mapped = ".";
            }
            patternBuffer.append(mapped);
            patternBuffer.append("{").append(count).append("}");
        }
        return patternBuffer.toString();
    }

}