public static void main(String args[]) {

    int[] aktiePris1 = new int[]{10, 7, 5, 8, 11, 9};
    ShareAnalyzer shareAnalyzer1 = new ShareAnalyzer(aktiePris1);
    printShareInfo(shareAnalyzer1);

    int[] aktiePris2 = new int[]{2, 12, 4, 7 , 11, 9, 1 , 8};
    ShareAnalyzer shareAnalyzer2 = new ShareAnalyzer(aktiePris2);
    printShareInfo(shareAnalyzer2); 
}