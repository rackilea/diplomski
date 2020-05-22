public String toString(){
String rm = super.toString();

this.stars=stars;
int t = stars;
String s ="";
for (int i=0; i<t;i++){
//      System.out.print("*");
    s+="*";

}

return  rm + "("+ s +")";
} }