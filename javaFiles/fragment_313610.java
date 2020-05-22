StringBuffer sb = new StringBuffer();
while (m.find()){
    m.appendReplacement(sb, /* decision about replacement*/ );
    //                         ^^^^^^^^^^^^^^^^^^^^^^^^^^
}
m.appendTail(sb);
String replaced = sb.toString();