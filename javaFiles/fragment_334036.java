...
    for (ObjetoOS os : tableOS)
    {
        for (String s : newOnes)
        {
            ArrayList<String> oldOnesPlusNewOne = new ArrayList<>();
            oldOnesPlusNewOne.addAll(os.getAtributo());
            oldOnesPlusNewOne.add(s);
            ObjetoOS newObj = new ObjetoOS(oldOnesPlusNewOne);
            tableOS.add(newObj);
        }
    }