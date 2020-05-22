String input = 
      "Barbara Liskov (born Barbara Jane Huberman on November 7, 1939 in California) "
    + "is a computer scientist.[2] She is currently the Ford Professor of Engineering "
    + "in the MIT School of Engineering's electrical engineering and computer "
    + "science department and an institute professor at the Massachusetts Institute " 
    + "of Technology.[3]";
//                                   | escaped opening square bracket
//                                   |  | any digit
//                                   |  |   | escaped closing square bracket
//                                   |  |   |      | replace with one space
System.out.println(input.replaceAll("\\[\\d+\\]", " "));