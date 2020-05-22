public void printISBN(string ISBN){
     for(String[] s_tab in books)
        if(s_tab[1].equals(ISBN)) 
           System.out.println(s_tab[0]);
     for(String[] s_tab in magazine)
        if(s_tab[1].equals(ISBN)) 
           System.out.println(s_tab[0]);
}