int xa = 0, xb = 0, xc = 1;
while(xc < min) {
    xa = xb;
    xb = xc;
    xc += xa;
}
StringBuilder sb = new StringBuilder();
for(int i = 0; i < nSequence && xc <= max; i++) {
    sb.append(xc);
    sb.append(' ');
    xa = xb;
    xb = xc;
    xc += xa;
}
t2.setText(sb.toString());