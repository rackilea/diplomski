if (borrowersMap.containsKey(name))
{
    borrowersMap.get(name).addItem(item)
}
else
{
    newBorrower = new Borrower(name);
    borrowersMap.put(newBorrower.getName(), newBorrower);
    newBorrower.addItem(item);
}