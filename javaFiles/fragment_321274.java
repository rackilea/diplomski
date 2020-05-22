import java.util.ArrayList;

class Splitter{
    static ArrayList<String> tokenize(String subject, String pattern)
    {
        ArrayList<String> tokens = new ArrayList<>();

        int tokenOff = 0;
        while(true)
        {
            int tokenPos = subject.indexOf(pattern, tokenOff);
            if(tokenPos == -1){ break; }
            String tok = subject.substring(tokenOff, tokenPos);

            addToken(tokens, tok);
            addToken(tokens, pattern);

            tokenOff = (tokenPos + pattern.length());
        }
        // Add any remaining characters
        addToken(tokens, subject.substring(tokenOff));

        return tokens;
    }

    static void addToken(ArrayList<String> list, String tok)
    {
        if(tok.length() > 0){ list.add(tok); }
    }

    public static void main(String args[])
    {
        String subject, pattern;
        ArrayList<String> tokens;

        subject = "ab#cd#ef#gh#"; 
        pattern = "#";
        tokens = tokenize(subject, pattern);
        System.out.println(tokens); // [ab, #, cd, #, ef, #, gh, #]

        subject = "ab##cd##ef##gh##"; 
        pattern = "##";
        tokens = tokenize(subject, pattern);
        System.out.println(tokens); // [ab, ##, cd, ##, ef, ##, gh, ##]

        subject = "ab##cd##ef##gh##ij"; 
        pattern = "##";
        tokens = tokenize(subject, pattern);
        System.out.println(tokens); // [ab, ##, cd, ##, ef, ##, gh, ##, ij]

        subject = "ab##cd#ef#gh##ij"; 
        pattern = "##";
        tokens = tokenize(subject, pattern);
        System.out.println(tokens); // [ab, ##, cd#ef#gh, ##, ij]
    }
}