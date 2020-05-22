boolean found = false;
    while (scanner.hasNextLine()) 
    {
        String lineFromFile = scanner.nextLine();
        if (rule_write.equals(lineFromFile))
        {
           found = true;
           break;
        }
    }

    if (!found) {
        // append rule_write to the file
        ...
    }