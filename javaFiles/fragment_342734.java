public String removeEntry(String name)
    {
        String result = null;
        int index = find(name);
        if (index >= 0)
        {
            result = thePhonebook[index].telno;
            thePhonebook[index] = thePhonebook[thePhonebookLength - 1];
            thePhonebook[--thePhonebookLength] = null;
        }
        return result;
    }