String content = reader.readLine();          //here you read a line
content.replaceAll("\\s+","");
while (reader.readLine() != null)            //here you read a line (once per loop iteration)
{
    content = content + reader.readLine();   //here you read a line (once per loop iteration)
}