writer.write("ping");
writer.write('\n');
writer.flush();

int i=0;
StringBuilder sb=new StringBuilder();
while((i=reader.read())!=-1){
    char c = (char)i;
    if(c == '\n')
        break;
    sb.append(c);
}
System.out.println("The server sends: "+sb);