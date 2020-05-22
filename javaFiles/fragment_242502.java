int[] Math = {85,65,40,20}; 
    int[] English = {35,55,68,75}; 
    int[] ICT = {50,35,69,95};

    int i; 
    int x=1;

    int[] marks = new int[4];

    if (x==1) {
           marks=Math;
    }
    else if (x==2) {
          marks=English;
    }
    else if (x==3) {
          marks=ICT;
    }

    for (i=0; i<4; i++ )
    {
        System.out.print(marks[i] + " ");
    }