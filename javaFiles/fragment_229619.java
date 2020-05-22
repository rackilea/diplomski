boolean first = (c1 == 'f') || (c1 == 't');
boolean second = (c2 == 'f') || (c2 == 't');

if (first && second) {
    if (c1 == 'f' && c2 == 'f')
        System.out.println("Both are false: " + 0);
    else if (c1 == 'f')
        System.out.println("First is false and second is true: " + 1);
    else if (c2 == 'f')
        System.out.println("First is true and second is false: " + 2);
    else
        System.out.println("Both are true: " + 3);
} else {
        System.out.println("No valid data entered");
}