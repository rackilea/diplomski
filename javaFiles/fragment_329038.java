@override
protected void process(List<String> wordsToPrint)
{
    String lastWordRecieved = wordsToPrint.get(wordsToPrint.size()-1);
    mainWindowTextArea.append(lastWord);  // not printing\appending all the words sent here by the publish calls
}

    @override
protected void done()
{
    publish("\nDone");
}