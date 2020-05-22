int numCourses;
int[] courseNumbers; // I would use a list here, but sticking with your data types for clarity.

while(input.hasNextLine()) {
    String line = input.nextLine();
    String[] lineParts = line.split(":");
    String label = lineParts[0];
    String value = lineParts[1];

    if(label.equals("number of courses")) {
        numCourses = Integer.parseInt(value);
    } else if(label.equals("course numbers")) {
        String[] courseNumberStr = value.split(" ");
        courseNumbers = new int[numCourses]; // you probably want to make sure numCourses was set and courseNumStr has the correct number of elements
        for(int i = 0; i < courseNumberStr.length; i++) {
            courseNumbers[i] = Integer.parseInt(courseNumberStr[i]);
        }
    } else if( /* handle the rest of the inputs */) {
        // etc
    }