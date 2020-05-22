String first = templist.get(0);
for (int i = 1; i < templist.size(); i++) {
    if(!templist.get(i).equals(first))
        return false;
}
return true;