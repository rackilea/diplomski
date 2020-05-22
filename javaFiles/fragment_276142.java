String sentence = "Check this answer and you can find the keyword with this code";
String search  = "keyword";

if ( sentence.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {

   System.out.println("I found the keyword");

} else {

   System.out.println("not found");

}