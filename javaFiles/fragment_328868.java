int cumlativeCount = 0;
for(int i = 0; i < nbLignes; i++) {
       // mettre le compteur de balles et de centres à 0
        for(int j = 0; j < nbColonnes;  j++){
            final int choix = choix_case(nbColonnes, cumlativeCount);
            grille[i][j] = choix; // vide  
            cumulativeCount = choix;              
        }
    }