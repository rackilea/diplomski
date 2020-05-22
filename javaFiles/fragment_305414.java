int counter = 0;
for (int rij = 0; rij < SPACE; rij++) {
    for (int kolom = 0; kolom < SPACE; kolom ++) { //you are supposed to increment kolom here, not rij
        spelbord[rij][kolom] = level.charAt(counter++); //increment counter after assignment
    }
}