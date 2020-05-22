public static void main(String args[]) {


     String line = "Will you open chrome?";
     //will get everything after open, including punctuation like the question mark.
     //You need to modify the regex if that's not what you want.
     String pattern = "open (.*)";

     // Create a Pattern object
     Pattern r = Pattern.compile(pattern);

     // Now create matcher object.
     Matcher m = r.matcher(line);

     if (m.find()) {
        System.out.println("Value after open is: " + m.group(1));
     } else {
        System.out.println("NO MATCH");
     }
  }