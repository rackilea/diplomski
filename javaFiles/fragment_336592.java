//Inefficient, but functional, does not test if input is in hex charset, so somewhat unsafe
//NOT tested, but should be functional
public static String encodeURL(String hexString) throws Exception {
  if(hexString==null || hexString.isEmpty()){
     return "";
  }
  if(hexString.length()%2 != 0){
    throw new Exception("String is not hex, length NOT divisible by 2: "+hexString);
  }
  int len = hexString.length();
  char[] output = new char[len+len/2];
  int i=0;
  int j=0;
  while(i<len){
      output[j++]='%';
      output[j++]=hexString.charAt(i++);
      output[j++]=hexString.charAt(i++);
  }
  return new String(output);
}