You can scan one more input value and get the code working as below:-
    ......
.........
            System.out.println("Enter a Input Type Integer->1 :: Char->2 :: Float->3::Double->4 ");
    int inputType = console.next();
    System.out.println("Enter a value: ");
    a = console.next();
    System.out.println("Enter another value: ");
    b = console.next();
    int v1,v2,v3;
    char vc1,vc2,vc3;
    float vf1,vf2,vf3;
    double vd1,vd2,vd3;
    switch(inputType)
    {
    case 1:
    {
        v1 = Integer.parseInt(a);
        v2 = Integer.parseInt(b);
        v3=larger(v1,v2);
    }
    case 2:
    {
        vc1 = a.charAt(0);
        vc2 = b.charAt(0);
        vc3=larger(vc1,vc2);
    }
    case 3:
    {
        vf1 = Float.parseFloat(a);
        vf2= Float.parseFloat(b);
        vf3=larger(vf1,vf2);
    }
    case 4:
    {
        vd1 = Double.parseDouble(a);
        vd2 = Double.parseDouble(a);
        vd3=larger(vd1,vd2);
    }
    }
......
.......