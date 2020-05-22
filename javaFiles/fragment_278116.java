public static void main(String[] args) {

    String[] nouns = new String[10];
    String[] verbs = new String[10];
    String[] adjec = new String[10];
    String[] adver = new String[10]; 

    nouns[0] = "Lion";
    nouns[1] = "Stewart";
    nouns[2] = "Timbaktu";
    nouns[3] = "Kilamanjaro";
    nouns[4] = "Hawai";
    nouns[5] = "Frog";
    nouns[6] = "Russia";
    nouns[7] = "Dimethyltryptaline";
    nouns[8] = "Dog";
    nouns[9] = "Badness";

    verbs[0] = "hear";
    verbs[1] = "achieve";
    verbs[2] = "smash";
    verbs[3] = "destroy";                   
    verbs[4] = "smoke";
    verbs[5] = "burn";
    verbs[6] = "rose";
    verbs[7] = "speak";
    verbs[8] = "type";
    verbs[9] = "be";

    adjec[0] = "Tangy";
    adjec[1] = "Sour";
    adjec[2] = "Smooth";
    adjec[3] = "Sticky";
    adjec[4] = "Soft";
    adjec[5] = "Black";
    adjec[6] = "Whispering";
    adjec[7] = "Resonant";
    adjec[8] = "Wide";
    adjec[9] = "Long";

    adver[0] = "Truthfully";
    adver[1] = "Endlessly";
    adver[2] = "Painfully";
    adver[3] = "Tirelessly";
    adver[4] = "Beautifully";
    adver[5] = "Uneasily";
    adver[6] = "Wickedly";
    adver[7] = "Briskly";
    adver[8] = "Now";
    adver[9] = "Last";

    String v = (verbs[new Random().nextInt(verbs.length)]);
    String a = (adjec[new Random().nextInt(adjec.length)]);
    String n = (nouns[new Random().nextInt(nouns.length)]);
    String ad = (adver[new Random().nextInt(adver.length)]);

    System.out.println("Does your " + v + " your " + a + " " + n + " " + ad );
}