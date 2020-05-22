private List<Character> list = new ArrayList<Character>();

int i=0;

BufferedReader br = new BufferedReader(new FileReader("pathToFile..."));

char c = '-1';

while (c!='\n') {
    list.add((char) br.read());
}