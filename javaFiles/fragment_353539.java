String allParams = "";

for (String currParam : param)
{
    allParams += ("param = " + currParam + " or "); 
}

allParams = allParams .substring(5, allParams .length() - 3);