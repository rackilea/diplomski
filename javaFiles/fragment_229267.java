Pattern pattern = Pattern.compile(":");
Matcher  matcher = pattern.matcher(line);

int patternMatch = 0;
while (matcher.find())
{
    patternMatch++;
}

while(patternMatch!=2)
{
    patternMatch=0;

    line = sc.nextLine();

    if(line.equals("quit")){
        break;
    }

    Pattern pattern = Pattern.compile(":");
    Matcher  matcher = pattern.matcher(line);

    while (matcher.find())
    {
        patternMatch++;
    }
}