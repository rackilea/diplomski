if ((age > 18 && age < 35) && (weight < 100) && (record == 'n') && (cert == 'y') && ((gender == 'm') && (height >= 1.85) || (gender == 'f') && (height >= 1.60)))        
{
    System.out.println("Congrats you are eligible to join the nGardai");
} else if (cert == 'n') {
    System.out.print("Do you commit to a 10 week Irish course on application < y or n > ");
    course = input.next().charAt(0);

    if (((age > 18 && age < 35) && (weight < 100) && (record == 'n') && (course == 'y') && ((gender == 'm') && (height >= 1.85) || (gender == 'f') && (height >= 1.60))))         
    {
        System.out.println("Congrats you are eligible to join the nGardai");
    } else {
        System.out.println("Sorry");
    }
}