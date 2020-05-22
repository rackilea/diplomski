public static void main(String[] args) {
  String str = "my name is Muneeb";
  String[] strarray = str.split(" "); //split on white space.

  for(int i=0; i<str.length(); i++){
     System.out.println(str.charAt(i));
  }

  for(int i=0; i<strarray.length; i++){
     System.out.println(strarray[i]);
  }
}