String sentance = "Dang the dang and DANG and I don't mind a dANg and some more";

StringBuilder sb = new StringBuilder(sentance.length());
while (sentance.toLowerCase().contains("dang")) {

    int index = sentance.toLowerCase().indexOf("dang");
    String start = sentance.substring(0, index);
    int endIndex = index + "dang".length();
    sb.append(start);
    sb.append("#!");

    sentance = sentance.substring(endIndex);

}

sb.append(sentance);

System.out.println(sb.toString());