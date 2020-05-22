while ((sCurrentLine = br.readLine()) != null) {
            String[] colonnes = sCurrentLine.split(" ");
            for(int i=1; i<colonnes.length; i++ ) {
                System.out.print(colonnes[i]+ " ");
            }
            System.out.println(); 
        }