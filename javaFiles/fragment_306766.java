static char getChoice() throws UserInputException
{
    BufferedReader br = new 
    BufferedReader(new InputStreamReader(System.in));
    char temp = (char)0;
    try {
        temp = (char)br.read();
    }
    catch (IOException ioEx) {
        throw new UserInputException ("Error reading input", ioEx);
    }
    return temp;
}