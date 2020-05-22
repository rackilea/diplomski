String[][] resultCard =  new String[][]{ 
    { " ", "A", "B", "C", "D", "E"},
    { "Maths", "78", "98","55","81","65" }, 
    { "Physics", "55", "65", "88", "80", "64"}, 
    { "Java", "73", "66", "69", "79", "79"},
    { "C#", "74", "78", "45", "73", "85"},
    { "Ethics", "80", "90", "60", "70", "80"}
 };

 int lowest = Integer.parseInt(resultCard[1][1]), tempInt;
 for(int row = 1; row <= resultCard.length; row++)
    for(int s = 1; s < resultCard[0].length; s++) {
        tempInt = Integer.parseInt(resultCard[row][s]);
        if(lowest > tempInt) lowest = tempInt; 
    }

 System.out.println("The Lowest Mark Out of All Classes Is: " + lowest);