int max = ... // maximum of the above values - only not empty values should be taken into account
int dy = 12;  // it seems you always leave 12 pixels between the lines
int y = ...;  // the value with the topmost y. It seems you use 202 when both names are present 214 when name2 is not given
int x = 250 - max + 46;

String[] labels = new String[] {name, name2, city, address, postal};
for (String label : labels) {
    if (label == null || label.length() == 0) {
        continue; // ignore null or empty values
    }
    g.drawString(name, x, y);
    y += dy;
}