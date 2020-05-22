text = org.apache.commons.lang3.StringEscapeUtils.escapeJava(text);
text = text.replaceAll("(?<!\\\\)\\\\n", "\n");// escape `\n` 
                                               // if it is not preceded with `\`
//do your job

//and now you can unescape your text (\n will stay \n)
text = org.apache.commons.lang3.StringEscapeUtils.unescapeJava(text);