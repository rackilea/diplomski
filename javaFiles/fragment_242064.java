static HashMap<String, Color> colorMap;

static {
    colorMap = new HashMap<>();
    colorMap.put("R",Color.parseColor("#EF5350"));
    colorMap.put("B",Color.parseColor("#7986CB"));
    colorMap.put("V",Color.parseColor("#FFE082"));
    colorMap.put("G",Color.parseColor("#FFFFFF"));
}

// ...

public int Colors(String col, int row) {
    if (colorMap.containsKey(col)) {
      return colorMap.get(col);
    }

    if (Math.floorMod(row, 2) == 0) {
      return Color.parseColor("#e0e0e0");
    }

    return Color.parseColor("#eeeeee");
}