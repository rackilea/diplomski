public int Colors(String col, int row) {
    switch (col) {
        case "R": return Color.parseColor("#EF5350");
        case "B": return Color.parseColor("#7986CB");
        case "V": return Color.parseColor("#FFE082");
        case "G": return Color.parseColor("#FFFFFF");
    }

    if (Math.floorMod(row, 2) == 0) {
      return Color.parseColor("#e0e0e0");
    }

    return Color.parseColor("#eeeeee");
}