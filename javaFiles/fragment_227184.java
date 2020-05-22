if (argv.length == 0) // Length it not a method

{
    System.out.println("Type in string");
    return; // the code should be stopped when it happens
}

String input = argv[0] + " ";// Avoid use this kind of name

int idx;
int lastIndex = 0;

// indexOf returns the index of the space
while ((idx = input.indexOf(' ', lastIndex)) != -1)
{
    System.out.println("[" + input.substring(lastIndex, idx) + "]");
    lastIndex = idx + 1;
}