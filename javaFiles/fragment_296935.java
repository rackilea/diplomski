if(line.equals("Movies")) {
    System.out.println("Hit Movies");
    while ((line = reader.readLine()) != null && !line.equals("Theaters")) {
       System.out.println("pasing ("+line+")");
        String currentline = line;
        String[] parts = currentline.split(":");
        String part1 = parts[0]; 
        String part2 = parts[1]; 
        movies.add(new Movie(part1, part2));
    }
    System.out.println("Finished Movies");
}