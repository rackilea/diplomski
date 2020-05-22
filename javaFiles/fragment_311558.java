String string = ...
for (;;)
{
    String original = string;
    string = string.replaceFirst("(<pre>.*?)a(.*?</pre>)", "$1b$2");
    if (original.equals(string))
        break;
}