Scanner fileScanner = new Scanner(file);    
List<String> array = new ArrayList<String>();

String previous, current, next;

while (fileScanner.hasNext())
{
    next = fileScanner.next());  // Get the next word
    if(current.equalsIgnoreCase(searchWord))
    {
        array.add( previous + current + next );
    }

    // Shift stuff
    previous = current;
    current = next;
    next = "";
}

fileScanner.close();

// Edge case check - if the last word was the keyword
if(current.equalsIgnoreCase(searchWord))
{
    array.add( previous + current );
}

// Do whatever with array
....