String personName = "Dean";
String[] suffix = {"eem", "een", "ean"};
String[] names = {"greem", "green", "grean"};

for(int i = 0; i < suffix.length; i++) {
    if (personName.endsWith(suffix[i])){
        System.out.println("That rhymes with " + names[i]);
    }
}