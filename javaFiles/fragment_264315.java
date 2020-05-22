do {
    assess = ConsoleInput.readInt ("Input number of assessments student completed");
    if((0 <= assess ) || (assess >= 5))
    {
        System.out.println("invalid assessment attendence. please enter again");
    }
} while ((0 <= assess) || ( assess >= 5));