Set<String> generationHistory = new LinkedHashSet<>();
    int colorIndex = 0;
    int index = boxes.size() > colors.size() ?  boxes.size() : colors.size();
    for(int i = 0; i < index; i++) {
        Map<String, String> row = new LinkedHashMap<>();
        output.add(row);
        colorIndex = i;
        for(int j = 0; j < index; j++) {
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
            // and it has not already been generated i all previous rows
            if(boxColors.contains(color) && isNotYetGenerated(box, color, generationHistory)) {
                row.put(box, color);
            }
        }
    }