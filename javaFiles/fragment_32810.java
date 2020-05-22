for(int y=0; y<=side2.length; y++) {
    if(side2[y] == null) {
        continue;
    }
    String g = side2[y].toString();
    // No further checks for null are necessary on side2[y]
    while(!side2[y].sRail.isEmpty()) {
        out.write(side2[y].sRail.pop().toString());
        out.newLine();
        out.newLine();
    }
    out.write(g);
}