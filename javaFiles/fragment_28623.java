public List<Map<String, String>> create(Map<String, List<String>> input) {
    List<Map<String, String>> output = new ArrayList<>();
    // find all boxes
    List<String> boxes = new ArrayList<>(input.keySet());

    // find all colors
    Set<String> distinctColors = new LinkedHashSet<>();
    for(List<String> e : input.values()) {
        for(String color : e) {
            if(! distinctColors.contains(color)) {
                distinctColors.add(color);  
            }
        }
    }
    List<String> colors = new ArrayList<String>(distinctColors);

    int colorIndex = 0;
    for(int i = 0; i < boxes.size(); i++) {
        Map<String, String> row = new LinkedHashMap<>();
        output.add(row);
        colorIndex = i;
        for(int j = 0; j < colors.size(); j++) {
            int boxIndex = j;
            if(boxIndex >= boxes.size()) {
                boxIndex = 0;
            }
            String box = boxes.get(boxIndex);
            List<String> boxColors = input.get(box);
            if(colorIndex >= colors.size()) {
                colorIndex = 0;
            }
            String color = colors.get(colorIndex++);
            // a combination is generated only if the actual
            // colors does exist in the actual box
            if(boxColors.contains(color)) {
                row.put(box, color);    
            }
        }
    }

    return output;
}