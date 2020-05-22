ArrayList<String> oldOnes= new ArrayList<String>(); // This line is pointless
oldOnes= os.getAtributo();                          // oldOnes will be overwritten here
    for (String s : newOnes)
    {
       oldOnes.add(s);
       ObjetoOS newObj = new ObjetoOS(oldOnes);
       aux.add(newObj );
       newObj = null;
       oldOnes.remove(s);
    }