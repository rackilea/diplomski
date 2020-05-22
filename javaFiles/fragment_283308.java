if (value < 65) {
    return 0;
}
if (value > 365) {
    return 100;
}
return (value - 65 / (365 - 65)) * 100;