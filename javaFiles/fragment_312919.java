content = texts.get(texts.size()-1).getText(); // get only the last one
bw.write(content + "\n"); // write last content
for(int i= 0; i<texts.size(); i++)
{
    texts.get(i).setEditable(false);
}