switch(codigo){
    case 'd':

    System.out.println ("Diga quantas palavras seu dicionario tera");
     numeroDePalavras = entry.nextInt();
   // entrada.nextLine();
    System.out.println ("Qual é a palavra?");

    for(i = 1; i < numeroDePalavras; numeroDePalavras--) {
    //Item[] itens = new Item[numeroDePalavras];
    System.out.println ("Qual é a palavra?");
    palavra = entry.nextLine();
    System.out.println ("Qual a categoria?");
    categoria = entry.nextLine(); 
    System.out.println (palavra+categoria);
  //  itens[numeroPalavras] = new Item(palavra, categoria);
    }
    break;