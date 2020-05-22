String s1 = "[1886bec8-334b-4be0-bcb6-3594c7e454b6, 4818dda2-e124-460d-b910-dc0386ceb138, e95cdfcb-14d6-4065-a69d-8f0213e1f8b4]";
String s2 = s1.substring(1,s1.length()-1);
String[] ss = s2.split(",");
for (String str : ss) {
        System.out.println(str.trim());
}