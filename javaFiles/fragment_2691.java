for(int j=0; j<3; j++){
        System.out.print("Inserisci il titolo del libro: ");
        try{
            titolo= br.readLine();
        }catch(Exception ex){
            System.err.println("ERRORE");
        }
        libri[j]=new Libro();
        libri[j].setTitolo(titolo);
        l.setTitolo(titolo); // This is no sense, you created a Libro in the previous lines