public void splitString(){
    String[] myArray = "Chapter 01<<<one<<<111111:::Chapter 02<<<two<<<222222:::Chapter 03<<<three<<<33333:::Chapter 04<<<four<<<4444:::Chapter 05<<<five<<<5555:::".split(":::");
    for (int j = 0; j < myArray.length; j++)
    {
        String[] songs = myArray[j].split("<<<");

        System.out.println("chapter: " + songs[0]);
        System.out.println("title: " + songs[1]);
        System.out.println("code: " + songs[2]);
    } 
}