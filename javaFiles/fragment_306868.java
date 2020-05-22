char * sprintfDouble(char *buf, double v, const char *floatFormat, const char *sciFormat, double thresholdLow, double thresholdHigh) {
    char *p;
    char *pd; /* pointer to '.' */
    char *pe; /* pd=, pe=pointer to 'e' (or null terminator) */
    char *buforig;
    int trimmed;
    if(v != v) { /* nan */
        sprintf(buf,"NaN");
        return buf;
    }
    if(v == v && (v - v) != 0.0) { /* infinity */
        sprintf(buf, v <  0 ? "-Infinity" :"Infinity");
    return buf;
    } 
    if(v==0) { /* positive or negative zero, dont distinguish*/
        sprintf(buf, "0.0");
    return buf;
    }
    buforig = buf;
    if(v <0) {
        v = -v;
        buf[0] = '-';
        buf++;
    }
    if( v > thresholdLow && v < thresholdHigh ) {
        sprintf(buf,floatFormat, v);
        pe = buf+strlen(buf);
        pd = (char *) strchr(buf,'.');
        if(pd == NULL) { /* no decimal point? add it */
            pd = pe;
            *pe++ = '.';
            *pe++ = '0';
            *pe = 0;
        }
    } else {
        sprintf(buf,sciFormat, v);
        pe  =  (char *)strchr(buf,'e');
        pd =   (char *)strchr(buf,'.');
        if(pd ==NULL) { /* no decimal point with scientific notation? rare but... */
            p= buf+ strlen(buf);
            while(p>=pe) {
                *p = *(p-2);
                p--;
            }
            pd = pe;
            *pe++ = '.';
            *pe++ = '0';
            *pe = 0;
        }
        /* three digits exponent with leading zero? trim it */
        if( (*(pe+2) == '0' ) && ( strlen(buf) - (pe-buf))==5) {
            *(pe+2)=*(pe+3);
            *(pe+3)=*(pe+4);
            *(pe+4)=*(pe+5);
        }
    } /* now trim trailing zeros  */
    trimmed = 0;
    p=pe-1;
    while(*p =='0' ) {
        p--;
        trimmed++;
    }
    if(*p=='.') {
        trimmed--;    // dont trim the zero after the decimal point
        p++;
    }
    if(trimmed>0) {
        p = pe;
        while(1) {
            *(p-trimmed) = *p;
            if(*p==0) break;
            p++;
        }
    }
    return buforig;
}

char * sprintfDouble5(char *buf,double v) {
    return sprintfDouble(buf, v, "%.5f", "%.5e", 0.01, 1000000.0);
}