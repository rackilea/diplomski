public String removeEntry(String name)
    {
        String result = null;
        int index = find(name);
        if (index >= 0)
        {
            result = thePhonebook[index].telno;
            for (int i = index + 1; i < thePhonebook.length; ++i)
            {
                thePhonebook[i - 1] = thePhonebook[i];
                if (thePhonebook[i] == null)
                {
                    break;
                }
            }
            thePhonebook[thePhonebook.length - 1] = null;
        }
        return result;
    }