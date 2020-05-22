String[] sentence = "i am a good boy".split(" ");
for(int j=0;j<sentence.length;j++)
{
    String realSentence = buildSentence(sentence, j);      
    rs2 = sentenceDBQuery(realSentence,srcLanguage,targLanguage);

    if(rs2.first()==true)
    {

        System.out.println("mon pass dan rs1 true");
        sb1.append(rs1.getString(targLanguage));
        sentencePart = sb1.toString();
        System.out.println(sentencePart);
    }
}

public String buildSentence(String[] parts, int index) {
    StringBuilder result = new StringBuilder();
    for (int j = 0; j < (parts.length - index); j++) {
        sb.append(parts[j]).append(" ");
    }
    sb.setLength(sb.length() - 1);
    return result.toString();
}