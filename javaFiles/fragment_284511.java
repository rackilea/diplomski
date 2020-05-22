boolean result1 = cover(values, amount - values[index], index+1);
if(!result1) {
    return cover(values, amount, index + 1);
} else {
    return true;
}