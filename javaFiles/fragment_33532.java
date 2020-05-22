public static void main(String[] args) {
    File file = new File("c:/Users/manna/desktop/example.txt");
    ArrayList<String[]> arrayOfPeople = new ArrayList<>();

    try {
        Scanner input = new Scanner(file);
        input.nextLine();                         //do this to skip the first line (header)
        while (input.hasNext()) {
            String num = input.nextLine(); 
            String[] personData = num.split(","); //returns the array of strings computed by splitting this string around matches of the given delimiter
            arrayOfPeople.add(personData);
        }

        int oldest   = Integer.parseInt(arrayOfPeople.get(0)[2].trim()); //Integer.parseInt("someString") parses the string argument as a signed decimal integer.
        int youngest = Integer.parseInt(arrayOfPeople.get(0)[2].trim()); //String.trim() returns a copy of the string, with leading and trailing whitespace omitted
        double totalWeight = 0;
        double totalHeight = 0;
        double totalAge    = 0;

        for(int i = 0; i< arrayOfPeople.size(); i++){
            String[] personData = arrayOfPeople.get(i);
            if(Integer.parseInt(personData[2].trim())>oldest){
                oldest = Integer.parseInt(personData[2].trim());
            }
            if(Integer.parseInt(personData[2].trim())< youngest){
                youngest = Integer.parseInt(personData[2].trim());
            }

            totalWeight = totalWeight + Double.parseDouble(personData[3].trim());
            totalHeight = totalHeight + Double.parseDouble(personData[4].trim());
            totalAge = totalAge + Double.parseDouble(personData[2].trim());
        }

        System.out.println("Oldest Person: " + oldest);
        System.out.println("Youngest  Person: " + youngest);
        System.out.println("Average Weight: " + totalWeight/arrayOfPeople.size());
        System.out.println("Average Height: " + totalHeight/arrayOfPeople.size());
        System.out.println("Average Age: " + totalAge/arrayOfPeople.size());

    } catch (FileNotFoundException e) {
        System.err.format("File Does Not Exist\n");
    }
}