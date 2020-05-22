String str = new String(strTF.getText());
char [] chr= str.toCharArray();
int n = chr.length;
char ch;
int i;
for(i = 0; i < n; i++) {
    if(i % 2 == 0) {
        ch = Character.toLowerCase(chr[i]);
       chr[i]=ch;
    } else {
        ch = Character.toUpperCase(chr[i]);
     chr[i]=ch;
    }
}
jumTF.setText(new String(chr)); }