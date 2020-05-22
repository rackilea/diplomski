double euro = 1.07;
final double dif = euro % 0.05;
if (dif > 0.025) {
    euro += 0.05 - dif;
} else {
    euro -= dif;
}