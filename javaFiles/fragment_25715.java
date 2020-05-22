int i = 0;
while (i <= r.size()) {
    g.drawRect(start.x, start.y, (cur.x - start.x), (cur.y - start.y));
    g.setColor(Color.gray);
    g.fillRect(start.x, start.y, (cur.x - start.x), (cur.y - start.y));
}