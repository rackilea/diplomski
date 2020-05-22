public class BlockedWords {

    public static void main(final String[] args) {
        //Various different types of white space within the input.
        final String[] input = {" A ~\n\r","\n\rB ~","\nE\r~"," G\n~"};

        final String[] urls = {"www.url.com/A","www.url.com/B","www.url.com/C","www.url.com/D",
                "www.url.com/E","www.url.com/F","www.url.com/G","www.url.com/H"};

        final BlockedWords whiteListing = new BlockedWords(input);

        for (final String url : urls) {
            if( whiteListing.containsBlockedWord(url) ) {
                System.out.println(url + " is blocked.");
                continue;
            }
            System.out.println(url + " is whitelisted.");
        }
    }


    private String[] blockedWords;

    public BlockedWords(final String[] blockedWords) {
        for (int i = 0; i < blockedWords.length; i++) {
            //Split on the ~ character to get an array of {"word", ""} then just take the word. in index 0.
            //Then trim it in case there are any whitespace characters still around the word.
            blockedWords[i] = blockedWords[i].split("~")[0].trim();
        }

        this.blockedWords = blockedWords;
    }

    public boolean containsBlockedWord(final String url) {
        for (final String blockedWord : this.blockedWords) {
            if( url.toLowerCase().contains( blockedWord.toLowerCase() ) ) {
                return true;
            }
        }
        return false;
    }
}