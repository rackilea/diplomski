int value   = 0;
int counter = 0;
String str  = "";
StringBuilder strb = new StringBuilder();

// Read until the end of the file
while((value = reader.read()) != -1)
{
    // Convert int to a character
    char c = (char)value;
    strb.append(c);

    // If the separator is found
    if (c == ','){

        str = strb.toString().replaceAll("^\"|\"$", "");
        switch (counter) {

            /* Do things according to the value of counter:
            Read description, data, title.. according to the data structure of what you are trying to parse 

            Example:
            case 1:  Description = str;
            break;
            case 2:  Band = str;
            break;
            */

        }

        // Prepare to read a new string and initialize the string builder
        strb.setLength(0);
        counter ++;
    }
}