int max = 0;
for (Music item : musicList) {
    if (item.getCode() > max) {
        max = item.getCode();
    }
}
int newCode = max++;