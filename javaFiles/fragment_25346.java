if(e < f)
    {
        System.out.println("????????????????"); //implemented to see how many times the loop runs; currently prints once
        String a = ""; String b = ""; //switchers
        d2[i][0] = a; d2[i][1] = b;
        d2[i][0] = d2[i+1][0]; d2[i+1][0] = a;
        d2[i][1] = d2[i+1][1]; d2[i+1][1] = b;
    }