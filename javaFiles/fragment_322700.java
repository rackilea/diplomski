String[] delimiters = {"/", "\\"};
String[] tokens = path.Split(delimiters);

StringBuilder result = new StringBuilder();

for(int i = 0; i < tokens.Length; i++)
{
    if(tokens[i].toLower().equals("bin") && (i > 0))
    {
        result.append(tokens[i-1]);
        for(int j = i+1; j < tokens.Length; j++)
        {
            result.append("_" + tokens[j]);
        }
        break;
    }
}

String finalPath = result.toString();