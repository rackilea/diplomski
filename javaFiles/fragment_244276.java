String[] titles = {"first name: ", "last name: ", ...}

int i = 0;
while((strLine = br.readLine())!= null)
{
    sb.append(titles[i] + strLine +"\n");
    i++;
}