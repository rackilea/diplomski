// missing part...
int len = 0, ch;
StringBuffer string = new StringBuffer();
// read the file char by char
while( (ch = fin.read()) != -1)
    string.append((char)ch);
fos1.close();
outputView.setText(string);