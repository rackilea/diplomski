int totCharacters=0, vowels=0, digits=0, odds=0, consecutive=0, index=0;
    String text;
    char ch;

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a sentence terminated with a full stop or exclamation mark: ");
    text = input.nextLine();

    do {
        ch = text.charAt(index);

        if(ch=='.' && ch=='!')
            break;

        if(index<text.length()-1)
            totCharacters++;
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            vowels++;
        if(ch>='0' && ch<='9')
            digits++;
        if(ch=='1' || ch=='3' || ch=='5' || ch=='7' || ch=='9')
            odds++;


    for(int i=index; i<text.length(); i++)
        {

             if(ch==text.charAt(i))
             {
                consecutive++;
             }
             else 
             {
                 break;
             }

        }
        index++;
        }while(ch!= '.' && ch!='!');