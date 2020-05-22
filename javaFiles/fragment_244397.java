public static void main(String[] args) {
String text = "This is a poor   sentence in grammar.";

String[] words = text.split("[^a-zA-Z]+");
for(int i=0;i<words.length;i++)
    if(words[i].length()>0)
        System.out.print(words[i].length()+" ");
}