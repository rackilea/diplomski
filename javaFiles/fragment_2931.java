String[] vowels = {"a","e","i","o","u"};
    String[] vowel = {"A","E","I","O","U"};
    String InputVowel = JOptionPane.showInputDialog(null,"Enter a Character: ");
    boolean isVowel = false;

    for (int x=0;x<vowels.length;x++)
    {
        if(InputVowel.equals (vowels[x])) {
            JOptionPane.showMessageDialog(null,InputVowel+" is a lowercase");
            isVowel = true;
            break;
        }
        if(InputVowel.equals(vowel[x])) {
            JOptionPane.showMessageDialog(null,InputVowel+" is an uppercase");
            isVowel = true;
            break;
        }
    }

    if (!isVowel)
        JOptionPane.showMessageDialog(null,InputVowel+" is an consaunant");