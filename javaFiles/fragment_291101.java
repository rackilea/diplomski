void print_all(TrieNode t, String parent) 
            // from here we have to recursively print all nodes if they are not null
    {
        if (t == null) // base condition
        {
            return;
        }

        parent += t.letter; // prepend parent to child
        if (t.fullword) {
                // only print when you reach a full word
            System.out.println(parent);
        }

        for (int i = 0; i < 26; i++) {
                // recurse into each child, prepending the parent's string
            print_all(t.links[i],parent);
        }
    }