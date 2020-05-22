public class StatePatternProgram {

    public static void main(String[] args) {
        String example = "{uniqueKey=test20745,content={acostumbrado={tf=1,df=1},al={tf=1,df=6945},ante={tf=1,df=42},co={tf=1,df=9187},ello={tf=1,df=2},está={tf=2,df=21},falcao={tf=1,df=105},guardia={tf=1,df=2},http={tf=1,df=9893},nada={tf=1,df=24},no={tf=1,df=2493},osa={tf=1,df=429},para={tf=1,df=6382},partido={tf=1,df=50},pretorian={tf=1,df=1},que={tf=1,df=358},sebcfkeı={tf=1,df=1},su={tf=1,df=7368},t={tf=1,df=14423},tuvo={tf=1,df=3},un={tf=1,df=8511}}}";
        ParseContext context = new ParseContext();
        Map<String, List<Integer>> map = context.parseContent(example);
        System.out.println(map);
    }
}

class ParseContext {

    private Map<String, List<Integer>> contentMap;

    private String currentKey;
    private List<Integer> currentList;

    private boolean continueParsing = true;
    private ParseState state = new StartParseState();

    public Map<String, List<Integer>> parseContent(String content) {
        StringTokenizer tokenizer = new StringTokenizer(content, "{}=,", true);
        while (continueParsing) {
            state.parse(tokenizer);
        }
        return contentMap;
    }

    interface ParseState {
        void parse(StringTokenizer tokenizer);
    }

    class StartParseState implements ParseState {
        @Override
        public void parse(StringTokenizer tokenizer) {
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (!"content".equals(token)) {
                    continue;
                }

                contentMap = new LinkedHashMap<String, List<Integer>>();

                tokenizer.nextToken();
                tokenizer.nextToken();

                state = new KeyParseState();
                break;
            }
        }
    }

    class KeyParseState implements ParseState {
        @Override
        public void parse(StringTokenizer tokenizer) {
            if (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (",".equals(token)) {
                    token = tokenizer.nextToken();
                }
                if ("}".equals(token)) {
                    state = new EndParseState();
                    return;
                }
                currentKey = token;
                tokenizer.nextToken();
                state = new ListParseState();
            }
        }
    }

    class ListParseState implements ParseState {
        @Override
        public void parse(StringTokenizer tokenizer) {
            currentList = new ArrayList<Integer>();
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if ("}".equals(token)) {
                    break;
                }
                if ("=".equals(token)) {
                    currentList.add(Integer.valueOf(tokenizer.nextToken()));
                }
            }
            contentMap.put(currentKey, currentList);
            state = new KeyParseState();
        }
    }

    class EndParseState implements ParseState {
        @Override
        public void parse(StringTokenizer tokenizer) {
            continueParsing = false;
        }
    }
}