int i=0;
    // Posting the contents
    for(String folders : content)
    {
        if(folders.toUpperCase().startsWith(userInput.toUpperCase()))
        {
            System.out.println("Name: " + folders);
            i++;
        }
    }
    System.out.println("Total number of results: " + i);`