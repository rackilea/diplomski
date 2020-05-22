String[] splitted = getMyCharacters.split(" ");


for(int j = 0; j < splitted.length; j++)
{
    System.out.println("\nCurrent word:" + splitted[j]);
    for(int y = 0; y < splitted[j].length(); y++)
    {
        System.out.println(splitted[j].charAt(y));
    }
}

output:
Current word:Hello
H
e
l
l
o

Current word:World
W
o
r
l
d