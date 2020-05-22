// Create lists to hold grades and names
List<String> names = new ArrayList<>();
List<Integer> grades = new ArrayList<>();
while (i++ < 3) {
    System.out.print("Enter The Students name  : ");
    first_name = BIO.getString();

    if (first_name.equals("END"))
        break;

    // Add name to list
    names.add(first_name);

    System.out.print("Their Module mark   : ");
    moduleMark = BIO.getInt();

    // Add grade to list
    grades.add(moduleMark);

}

// Iterate both lists at once, printing inside the loop
for(int i = 0; i < names.size(); i++) {
    String name = names.get(i);
    Integer grade = grades.get(i);

    if (grade >= 40) {
        System.out.println(name + " Pass");

    } else {
        System.out.println(name + " Fail");

    }

}