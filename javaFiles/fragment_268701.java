int ind = 0;
int cnt = 0;
while (true) {
    int pos = first.indexOf(second, ind);
    if (pos < 0) break;
    cnt++;
    ind = pos + 1; // Advance by second.length() to avoid self repetitions
}
System.out.println(cnt);