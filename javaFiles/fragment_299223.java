public static boolean check(List<String> d, List<String> a,int i) { 
    int ct=0; 
    for (int r = 0; r < d.size(); r++) { 
        if (r==i) 
        continue; 
        if((d.get(i)).equals(a.get(i)))
        ct++;
    }
    if(ct==d.size()-1)
    return true;
    return false;
}