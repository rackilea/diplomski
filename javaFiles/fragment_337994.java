String[] msgs = { "A", "B","C","D","E","F","G","H" };
int cnt = 0;
for (String s : msgs) {
    g.translate(0, (cnt * 2));
    cnt++;
    // moving x here for demo purposes - y is always 0 but translate moves it down
    g.drawString(s,(20*cnt),0);
}