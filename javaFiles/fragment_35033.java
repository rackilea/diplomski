int res;
if(chaIntVal >= 0x10) {
    res = chaIntVal;
} else {
    res = chaIntVal | 0x60;   // binary or
}