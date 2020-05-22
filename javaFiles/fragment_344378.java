Map<String, String[]> map = //Map with data
try(BufferedWriter writer = new BufferedWriter(new FileWriter("<your_file>"))){
    for(Map.Entry<String, String[]> entry : map.entrySet()){
        writer.write(String.join(",", entry.getValue()));
        writer.newLine();
    }
}