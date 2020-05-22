String s = "abc 123/ 456/";

String[] splitBySpace = s.split(" ");
String prefix = splitBySpace[0];

String[] partsOfS = new String[splitBySpace.length - 1];

for (int i = 1; i < splitBySpace.length; i++) {
    partsOfS[i - 1] = splitBySpace[i].replace("/", "");
}

for (int i = 0; i < partsOfS.length; i++) {
    System.out.println(prefix + " " + partsOfS[i]);
}