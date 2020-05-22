public static char randomChar(){
    char spl[] = "!@#$%^&*()".toCharArray(); 
    // Or char spl[] = {'!', '@', '#', '$', '%', '^', '&', '*'. '(', ')'};



    Random r = new Random();
    int Low = 0;
    int High = spl.length + 1;
    int Result = r.nextInt(High-Low) + Low;

    return spl[Result];

}