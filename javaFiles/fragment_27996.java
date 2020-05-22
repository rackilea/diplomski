List<String> toWrite = new ArrayList<>();

for(int i = 0; i<lines.size(); i++){
    String line = lines.get(i);
    if(line.startsWith("0327159")){
        String updated = line.trim() + ", more text\n";
        toWrite.add(updated);
    } else{
        toWrite.add(line);
    }
}