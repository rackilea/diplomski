public static void main(String[] args) throws ParseException {
    final String[] strings = new String[]{
        "[Name: Bob][age: 27][cprNumber: 1234][group: A][Active: true][Average Grade: 4.1]",
        "[Name: Alice][age: 17][cprNumber: 4321][group: A][Active: true][Average Grade: 4.5]",
        "[Name: James][age: 33][cprNumber: 2134][group: B][Active: true][Average Grade: 2.2]",
        "[Name: Frank][age: 23][cprNumber: 3124][group: B][Active: false][Average Grade: 3.1]"
    };
    final Collection<Float> grades = new LinkedList<Float>();
    for (final String string : strings) {
        final String[] values = string.split("[\\[\\]]+|:");
        final float gpa = Float.parseFloat(values[12].trim());
        if (gpa > 4) {
            grades.add(gpa);
        }
    }
    System.out.println(grades);
}