String l=s.toLowerCase();
boolean check = true;

for(int i= 0; i<l.length();i++){
    int count=0;
    for(int j=0;j<l.length();j++){
        if(l.charAt(i)==l.charAt(j)) count++;
     }
     if (count != 2) {
         check = false;
         break;
     }
}
if(check==true){
    System.out.println("True, This is a doubloon");
}else
    System.out.println("False, This is not a doubloon");
}