String s = "FOO()FOOL()SOMEFOO()FOO";

Pattern p = Pattern.compile("\\bFOO\\b");
Matcher m = p.matcher(s);

int count = 0;
while (m.find()) {
    count++;
}

// count= 2