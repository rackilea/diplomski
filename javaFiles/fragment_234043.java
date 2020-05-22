public String getElement(int index){
        if (index != lastProbed)
            probeCount++;
        lastProbed = index;
        if (table[index] != null) {
           return table[index].str;
        }
        return null;
}