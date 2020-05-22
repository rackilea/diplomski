String text = "\\par }{\\b\\f1\\fs24\\ul\\insrsid14762702 Data}{\\insrsid14762702 \\tab \\tab }{\\b\\f1\\fs24\n\\par Start:\\tab 2015-01-14 10:56:25\n\\par Duration:\\tab 22:40:23\n\\par Positions:\\tab 3.0, 5.0, 7.0, 9.0, 15.0, 17.0 cm\n\\par Sensor Position(s):\\tab -10.0, 5.0 cm\n\\par Depth:\\tab N/A\n\\par \n\\par }{\\b\\f1\\fs24\n\\par }{\\b\\f1\\fs24\\ul\\insrsid14762702 History}{\\insrsid14762702 \n\\par Other \n{\\b\\f1\\fs24\\ul\\insrsid14762702";       
String tag = Pattern.quote("{\\b\\f1\\fs24");

Pattern p = Pattern.compile( "([^\n]*" + tag + "[^\n]*\n.*?)(?=([^\n]*" + tag + "))",
            Pattern.DOTALL );

Matcher m = p.matcher( text );

List<String> matches = new ArrayList<>();
while(m.find()) {
    matches.add(m.group(1) + m.group(2));
}

for (String s: matches)
    System.err.println(s + "\n");