public static void solve(String word) {
    solve(word, 0);
}

public static void solve(String word, int it) {

    // print starting spaces
    String spaces="";
    for(int i = 0; i < it; i++)
        spaces+=" ";


    if(word.length() > 2) {
        int newlengthperside = (word.length() - 2)/2;
        solve(word.substring(0, newlengthperside) + word.substring(word.length() - newlengthperside), it + 1);
    }
    System.out.print(spaces+word+"\n");
}