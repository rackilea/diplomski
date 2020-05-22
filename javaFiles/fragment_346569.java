if (x+d >= x2 && x <= x2 && y+d >=y2 && y <= y2) {
s++;
d = d + s*10;
System.out.println("PUNKT");
pen.setColor(Color.BLACK);
pen.fillRect(x2, y2, 10, 10);
w = 1;
if (s == 10) {
JOptionPane.showMessageDialog(frame, "Achievement get: " + s + "Punkte!");
        }