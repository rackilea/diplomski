public int[][][] loadMap() {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass()
            .getResourceAsStream("map.txt"), StandardCharsets.ISO_8859_1))) {

        List<int[][]> result = new ArrayList<>();
        List<int[]> cur = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null) {
            line = line.trim();
            if(line.isEmpty() && !cur.isEmpty()) {
                result.add(cur.toArray(new int[0][]));
                cur.clear();
            } else {
                String[] cells = line.split("\\s+");
                int[] row = new int[cells.length];
                for(int i=0; i<cells.length; i++) row[i] = Integer.parseInt(cells[i]);
                cur.add(row);
            }
        }
        if(!cur.isEmpty())
            result.add(cur.toArray(new int[0][]));
        return result.toArray(new int[0][][]);
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
}