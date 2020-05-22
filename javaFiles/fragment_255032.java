private static int[] available = new int[]{3,3,3,5,6};
    private static int[] fixed = new int[available.length];

    public static void main(String[] args)
    {
        Main.keep(3);
        Main.keep(5);

        System.out.println(Arrays.toString(available));
        System.out.println(Arrays.toString(fixed));
    }

    public static void keep(int value) 
    {
          for (int i = 0; i < available.length; i++)
          {
              if(available[i] == value)
              {
                  for (int j = 0; j < fixed.length; j++) 
                  {
                      if (fixed[j] == 0) 
                      {
                          fixed[j] = value;
                          break;
                      }
                  }
                  for(int k = i; k<available.length-1; k++) 
                  { 
                      available[k] = available[k+1]; 
                  }
                  available[available.length-1] = 0;
                  break;
              }
          }
    }