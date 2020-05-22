String[] expectedSentenceA = "The quick brown fox jumps over the lazy dog".split(" ");
String[] inputStringA = inputString.split(" ");
int diff=  expectedSentenceA.length-inputStringA.length;
if(diff>0) {
    System.out.println("You have missed " + diff + " word(s)..!!!");
} else if (diff < 0) {
    System.out.println("Found " + diff + " excess word(s)..!!!");
}else {
   ArrayList<String> mistakeWords= new ArrayList();
   for(int i=0;i<expectedSentenceA.length;i++) {
    if(!expectedSentenceA[i].equals(inputStringA[i])){
        mistakeWords.add(inputStringA[i]);
    }
   }
   JOptionPane.showMessageDialog(null,"Total Mistakes ["+mistakeWords.size()+"] are " + mistakeWords);
}