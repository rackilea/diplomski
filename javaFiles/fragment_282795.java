if (i == 0) {
    min = scores[i];
    max = scores[i];
}else {
    if (students < min) min = scores[i];
    if (students > max) max = scores[i];
}
sum += scores[i];