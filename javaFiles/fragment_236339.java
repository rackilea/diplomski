public static String getresolution()
{
    String resolution;
    boolean validAnswer = false;
    Scanner input = new Scanner(System.in);
    HashSet<String> validResolutions = new HashSet<>();
    validResolutions.add("800x600"); 
    validResolutions.add("1024x768"); 
    validResolutions.add("1152x900");
    //add more resolutions if you want without having to create a bigger if check 
    //validResolutions.add("1400x1120");

    do {
        System.out.print("Please enter video resolution: ");
        resolution = input.nextLine().replaceAll(" ", "").replaceAll("\n", "");
        validAnswer = validResolutions.contains(resolution) ? true : false;
        if(!validAnswer)
            System.out.println("Incorrect resolution please try again");
    } while (!validAnswer);

    return resolution;
}