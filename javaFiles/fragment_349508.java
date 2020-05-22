String str = "Tempo 5 min: Introduzione e presentazioni. Appello con lettura nominale. (a)\n\nTempo 20 min: \"Prova iniziale?\" Tentativo in base al numero dei presenti. (b)\n\nTempo 10 min: “Prova secondaria”. Test attitudinale. Verifica e confronto. (c)\n\nTempo 15 min: Discussione di gruppo dei risultati (primo, secondo, terzo...) (d)";
Pattern pattern = Pattern.compile("(.*?(?:\\.|(?<=\" )| (?=\\())).*(\\(.*)");
Matcher matcher = pattern.matcher(str);

while (matcher.find())
{
    System.out.println(matcher.group(1)+matcher.group(2));
}