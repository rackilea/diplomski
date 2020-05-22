   void read_trie(String find) // pass the intial string
    {
        int len = find.length();
        int i = 0;

        TrieNode temp = root; // copy root

        String match = "";
        while (i != len) // go until the string matches
        {
            int t = find.charAt(i);
            t = t - 97;

            temp = temp.links[t];
            if (temp==null) break;
            match += temp.letter;

            i++;
        }

        // Remove the last letter since it's added in the print code below
        if (match.length()>0) match = match.substring(0, match.length()-1);
        print_all(temp, match); // pass the node
    }