String current = "";
int temp = 0;
for (int i = 0; i < goldWords.length - N_GRAM_ORDER; i++) {
    current = current + ":" + goldWords[i];
    while (temp < N_GRAM_ORDER) {
        current = current + ":" + goldWords[temp + i];
        temp++;
    }
    goldNGrams.add(current);
    current = "";
    temp = 0;
}
}