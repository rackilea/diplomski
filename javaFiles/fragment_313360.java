Path path = Paths.get("ScalModel.txt");
List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);    

int position = 75;
String extraLine = "MainAttack -OR-> {";

for (int d = 10; d >= 1; d--) {        
    extraLine += "AttackNode"+d;
    if(d==1) extraLine += "}";
    else extraLine += ",";
}

lines.add(position, extraLine);
Files.write(path, lines, StandardCharsets.UTF_8);