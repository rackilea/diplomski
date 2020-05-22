public class createCards {

decoyObject d = new decoyObject();

public decoyObject storeCards(){
    storeHearts();
    storeClubs();
    storeSpades();
    storeDiamonds();
    return d;
}

public void storeHearts(){
 String[] heartRay = new String[13];
 heartRay[0] = "AceH";
 int L = heartRay.length - 4;
 for(int i = 0; i <= L; i++){
     Integer h = i + 2;
     String heartPlace =  h.toString()+"H";
     heartRay[i+1] = heartPlace;
 }
 heartRay[10] = "JackH";
 heartRay[11] = "QueenH";
 heartRay[12] = "KingH";

 d.setHearts(heartRay);

}


 public void storeClubs(){
 String[] clubRay = new String[13];
 clubRay[0] = "AceC";
 int L = clubRay.length - 4;
 for(int i = 0; i <= L; i++){
     Integer h = i + 2;
     String clubPlace = h.toString() + "C";
     clubRay[i+1] = clubPlace;
 }
 clubRay[10] = "JackC";
 clubRay[11] = "QueenC";
 clubRay[12] = "KingC";

d.setClubs(clubRay);
}

 public void storeSpades(){
 String[] spadeRay = new String[13];
 spadeRay[0] = "AceS";
 int L = spadeRay.length - 4;
 for(int i = 0; i <= L; i++){
     Integer h = i + 2;
     String spadePlace = h.toString() + "S";
     spadeRay[i+1] = spadePlace;
 }
 spadeRay[10] = "JackS";
 spadeRay[11] = "QueenS";
 spadeRay[12] = "KingS";

d.setSpades(spadeRay);

}

 public void storeDiamonds(){
 String[] diamondRay = new String[13];
 diamondRay[0] = "AceD";
 int L = diamondRay.length - 4;
 for(int i = 0; i <= L; i++){
     Integer h = i + 2;
     String diamondPlace = h.toString() + "D";
     diamondRay[i+1] = diamondPlace;
 }
 diamondRay[10] = "JackD";
 diamondRay[11] = "QueenD";
 diamondRay[12] = "KingD";

d.setDiamonds(diamondRay);

}

}