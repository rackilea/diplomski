for(int i = 0; i < 10; i++) { //This will run 10 times
    nome = keyboard.next();
    if(nome.equalsIgnoreCase("fim")) { //This will verify if last input was "fim"
        break; //This breaks the for-loop
    }
}