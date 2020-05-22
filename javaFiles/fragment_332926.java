boolean etape = true;
   while(etape){
    etape = false;
    System.out.println("Entrer un generateur :");
    generateur = sc.nextInt();


        for(int s=0;s<facteur.size();s++){      


            b=Math.pow(generateur,(nombre/facteur.get(s)))%(nombre+1);
            System.out.println("b= "+b);
            if(b==1){
               etape = true;
               break;

            }

        }   
 }
 return generateur;