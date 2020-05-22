public static <T> boolean equalsExceptForNulls(T[] ts1, T[] ts2) {
    if (ts1.length != ts2.length) return false;
    for(int i = 0; i < ts1.length; i++) {
       T t1 = ts1[i], t2 = ts2[i];
       if (t1 != null && t2 != null && !t1.equals(t2)) 
           return false;
    }
    return true;
}

public static <T> boolean equalsExceptForNulls3(T[] ts1, T[] ts2, T[] ts3) {
    return equalsExceptForNulls(ts1, ts2) && 
           equalsExceptForNulls(ts1, ts3) && 
           equalsExceptForNulls(ts2, ts3);
}
// or generically
public static <T> boolean equalsExceptForNulls(T[]... tss) {
    for(int i = 0; i < tss.length - 1; i++)
       for(int j = i + 1; i < tss.length; j++)
           if(!equalsExceptForNulls(tss[i], tss[j]) 
               return false;
    return true;
}