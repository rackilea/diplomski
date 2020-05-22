// Number of lines to print
final int PRINT_COUNT = 4;

// Check to make sure there are actually 4 lines in the file
if(lines.size() < PRINT_COUNT)
    throw new IllegalStateException("Too few lines in file. Total lines="+lines.size());

// Declare a set to record which lines were selected
Set<Integer> chosen = new HashSet<>();

Random r = new Random();

for(int i = 0; i < PRINT_COUNT;) {

    int nextInt = r.nextInt(lines.size());

    if(!chosen.contains(nextInt)){
        chosen.add(nextInt);
        System.out.println(lines.get(nextInt));
        i++; 
    }
}