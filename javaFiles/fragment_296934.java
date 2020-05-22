if(line.equals("Movies")) {
    while ((line = reader.readLine()) != null && !line.equals("Theaters")) {
        String currentline = line;
        String[] parts = currentline.split(":");
        String part1 = parts[0]; 
        String part2 = parts[1]; 
        movies.add(new Movie(part1, part2));
    }
}