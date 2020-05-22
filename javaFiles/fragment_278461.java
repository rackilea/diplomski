String haystack = "the red cat is watching the red car stopped at the red stop sign";
String needle = "red";
int idx = 0, pos;
while( (pos = haystack.indexOf(needle,idx)) != -1) {
        System.out.println(pos+1);
        idx += pos+1;     
}