while (k1 < timea.length && k2 < timeb.length ) {
        omega.setAsInt(1, k1, k1);
        omega.setAsInt(-1, k1, k1 + 1);
        omega.setAsInt(-1, k1 + 1, k1);
        omega.setAsInt(1, k1 + 1, k1 + 1);
        Bigomega = Bigomega.plus(omega);
        omega.clear();
    if (timea[k1] < timeb[k2])
        k1++;
     else          
        k2++;        
}