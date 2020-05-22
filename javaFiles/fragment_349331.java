public class App 
{
    final static Rule printRule = new Rule() {
        public void begin(String namespace, String name,
                Attributes attributes) throws Exception {
            System.out.println(name);
        }
    }; 
    public static void main( String[] args ) throws IOException, SAXException
    {
        InputStream instr = App.class.getResourceAsStream("/sample.xml");
        Digester dig = new Digester();
        dig.setRules(new RulesBase(){
            public List<Rule> match(String namespaceURI, String pattern) {
                return Arrays.asList(printRule);
            }
        });
        dig.parse(instr);
    }
}