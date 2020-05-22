String first = templist.get(0);
for (String s : templist) {
    if(!s.equals(first))
        return false;
}
return true;