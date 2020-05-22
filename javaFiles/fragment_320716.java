Scanner sc = new Scanner(System.in);
       String ret;
       String qnum;
       String ans;

       String correct = "Awesomely correct!";
       String wrong = "Darn it! Almost got it!";

       System.out.println("Do you think you know your stuff?");
       ret = sc.nextLine();

       if (ret.equals("yes") || ret.equals("Yes"))
       {
        System.out.println("Well, then let's test what you know! Choose a number from 1 to 5!");
        qnum = sc.nextLine();
          switch (qnum)
          {
         case "1":
        System.out.println("In what year did the French Revolution start?");
        ans = sc.nextLine();
          if (ans.equals("1789") || ans.equalsIgnoreCase("seventeen eighty nine"))
          {System.out.println(correct);}
          else
          {System.out.println(wrong);}

         break;

        case "2":
        System.out.println("How many protons does a sodium atom have?");
        ans = sc.nextLine();
        sc.nextLine();
          if (ans.equals("11") || ans.equalsIgnoreCase("eleven"))
          {System.out.println(correct);}
          else
          {System.out.println(wrong);}

         break;

        case "3":
        System.out.println("What is 2^6*0.5-12?");
        ans = sc.nextLine();
        sc.nextLine();
          if (ans.equals("20") || ans.equalsIgnoreCase("twenty"))
          {System.out.println(correct);}
          else
          {System.out.println(wrong);}

         break;

        case "4":
        System.out.println("Which is the lowest numbered element in the periodic table?");
        ans = sc.nextLine();
        sc.nextLine();
          if (ans.equalsIgnoreCase("hydrogen"))
          {System.out.println(correct);}
          else
          {System.out.println(wrong);}

         break;

        case "5":
        System.out.println("Which is the unit that measures Coulombs per second?");
        ans = sc.nextLine();
        sc.nextLine();
          if (ans.equalsIgnoreCase("ampere"))
          {System.out.println(correct);}
          else
          {System.out.println(wrong);}

         break;
        default:
        System.out.println("Stick to the rules! 1-5!");
         }

      }
       else
       {System.out.println("Not liking that attitude, I want to hear a big yes!");}