String[] b = new String[a.length - index];
String tmp = a[0];

for(int i = 1; i < a.length; i++) {
    if(i <= index) {
        tmp += " " + a[i];

        if(i == index) {
            b[i - index] = tmp;
        }
    }
    else {
        b[i - index] = a[i];
    }
}