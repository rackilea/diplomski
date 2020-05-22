for (int value : A) {
    if (value == 0) {
        mult++;
    } else {
        result += mult;
        if (result > 1000000000) {
            return -1;
        }
    }
}
return result;