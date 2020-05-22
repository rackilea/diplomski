int val = 1 + tmap.getOrDefault(key, 0);
tmap.put(key, val);
if (val > maxVal) {
    maxVal = val;
    maxKey = key;
}