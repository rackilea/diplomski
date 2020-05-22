/* developed by Christian Traina
    * email address: crissstian96@gmail.com
   */

public class Alpha {
private Alpha[] alpha = new Alpha[26];
private boolean mark = false;

// SEARCH
public boolean search(String s){
    return search(s.toCharArray());
}
public boolean search(char[] s){
    return search(s,0);
}
private boolean search(char[] s, int p){
    if(p==s.length)
        return mark;
    if(alpha[s[p]-97]!=null)
        return alpha[s[p]-97].search(s, p+1);
    else
        return false;
}

//MATCHES
//THE ASTERISK MEANS ANY CHARACTERS
//FOR EXAMPLE, IF YOU WANT TO SEARCH A WORD OF SIX LETTERS THAT BEGINS WITH THE LETTER A, 
//YOU HAVE TO PASS "A*****"
public boolean matches(String s){
    return matches(s.toCharArray(), 0);
}
private boolean matches(char[] s, int p){

    if(p==s.length)
        return mark;
    if(s[p]=='*'){

        for(int i=0; i<26; i++)
            if(alpha[i]!=null && alpha[i].matches(s,p+1))
                return true;

        return false;
    }
    else if(alpha[s[p]-97]!=null)
        return alpha[s[p]-97].matches(s, p+1);

    else
        return false;
}


// ADD

public void add(String s){
    add(s.toCharArray(), 0);
}
public void add(char[] s){
    add(s,0);
}
private void add(char[] s, int p){
    if(p==s.length)
        mark=true;
    if(p>=s.length)
        return;
    if(alpha[s[p]-97]==null)
        alpha[s[p]-97] = new Alpha();
    alpha[s[p]-97].add(s, p+1);
}


//PRINT
//IT PRINTS ALL THE ITEMS OF THE TREE


public void print(){
    for(int i=0; i<26; i++)
        if(alpha[i]!=null){
            alpha[i].print(Character.toString((char)(i+97)));
        }
    System.out.println();
}

private void print(String str){
    if(mark)
        System.out.print(str+" ");
    for(int i=0; i<26; i++)
        if(alpha[i]!=null){
            alpha[i].print(str+Character.toString((char)(i+97)));
        }

}
}