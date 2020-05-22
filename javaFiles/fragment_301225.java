String str = "Some String";
int numberOfChars = str.length();
StringReader sr = new StringReader(str);
char[] chars = new char[numberOfChars];
int i = 0, read = 0;

try {
    while ((read = sr.read()) != -1) {
        chars[i] = (char)read;
        i++;
    }
} catch (IOException e) {
    // handle the exception
}