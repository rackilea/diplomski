int rnd;
      Random rand = new Random();
      ArrayList<Integer> numbersRbra = new ArrayList<Integer>();

      Button[] buttonListRbra = new Button[9];
      buttonListRbra[0] = (Button)findViewById(R.id.tap1);
      buttonListRbra[1] = (Button)findViewById(R.id.tap2);
      buttonListRbra[2] = (Button)findViewById(R.id.tap3);
      buttonListRbra[3] = (Button)findViewById(R.id.tap4);
      buttonListRbra[4] = (Button)findViewById(R.id.tap5);
      buttonListRbra[5] = (Button)findViewById(R.id.tap6);
      buttonListRbra[6] = (Button)findViewById(R.id.tap7);
      buttonListRbra[7] = (Button)findViewById(R.id.tap8);
      buttonListRbra[8] = (Button)findViewById(R.id.tap9);

      for (int i=0; i < 9; i++) // Loop through your entire list to access all your 9 Buttons
      {
          rnd = rand.nextInt(9) + 1; // Return an int in the range [1,9] => 9 elements

          if(i==0)
          {
              numbersRbra.add(rnd);
              buttonListRbra[i].setText(numbersRbra.get(i)); // Set the Button Text for the first iteration too
          }
          else
          {
              while(numbersRbra.contains(rnd)) // Transformation between Integer and int done automatically
              {
                  rnd = rand.nextInt(9) + 1; // Return an int in the range [1,9]
              }
              numbersRbra.add(rnd);
              buttonListRbra[i].setText(numbersRbra.get(i)); // Set it after finding the correct number
          }
      }