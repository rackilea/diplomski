while (fileScanner.hasNext())
    {
        String nextWord = fileScanner.next();
        if (!words.contains(nextWord))
        {
            words.add(nextWord);
        }
    }