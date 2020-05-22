int indexOf (string s1, string s2) {

        if (s1 == "" && s2 == "") {
            return 0;
        } else if (s1 == "") {
            return -1;
        } else if (s2=="") {
            return 0;
        } else if (s2.size()>s1.size()) {
            return -1;
        }
        else if (s1 [0] == s2[0]) {
            int subIndex = indexOf(s1.substr(1,s1.length()),s2.substr(1,s2.length()));
            return  subIndex == -1 ? -1: subIndex;


        } else {
            int subIndex = indexOf(s1.substr(1,s1.length()),s2);
            return  subIndex == -1 ? -1: subIndex+1;
        }

    }