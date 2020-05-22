class listCreator {

    public String createList(String source) {
        int currentLevel = 0; //Level 0 means beginning, level 1 means a single > was present and so on
        int nextLevel = 0;
        StringBuilder sb = new StringBuilder();
        //Assumes source is to be split on newlines
        String[] tmp = source.split("\n");
        for (String t: tmp) {
            //Needs validation, if source is not what we expect it'll blow up...
            //We are expecting a number of > followed by a space
            String[] levelContent = t.split(" ");
            nextLevel = levelContent[0].lastIndexOf(">") + 1;

            if (nextLevel == currentLevel) {
                sb.append("</li>\n<li>");
                sb.append(levelContent[1]);
            } else if (nextLevel > currentLevel) {
                sb.append("<ul>\n<li>");
                sb.append(levelContent[1]);
            } else if (nextLevel < currentLevel) {
                for (int i = 0; i < currentLevel-nextLevel; i++) {
                    sb.append("</li>\n</ul>\n");
                }
                sb.append("</li>\n<li>");
                sb.append(levelContent[1]);
            }

            currentLevel = nextLevel;
        }
        //Close up remaining levels
        for (int i=0; i < currentLevel; i++) {
            sb.append("</li>\n</ul>\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String source1 = "> 1\n> 2\n>> 2.1\n>> 2.2\n>>> 2.2.1\n>>> 2.2.2\n> 3\n";
        String source2 = "> 1\n> 2\n>> 2.1\n>> 2.0.1\n>>> 2.0.1.2\n>> 2.2\n>>> 2.2.1\n>>> 2.2.2\n> 3\n";
        listCreator lc = new listCreator();
        System.out.println(lc.createList(source1));
        System.out.println(lc.createList(source2));
    }

}