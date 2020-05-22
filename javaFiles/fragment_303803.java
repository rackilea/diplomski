public static void main(String args[])
    {
        Scanner dis=new Scanner(System.in);
        int a,b,c;
        String line;
        String[] lineVector;

        line = dis.nextLine(); //read 1,2,3

        //separate all values by comma
        lineVector = line.split(",");

        //parsing the values to Integer
        a=Integer.parseInt(lineVector[0]);
        b=Integer.parseInt(lineVector[1]);
        c=Integer.parseInt(lineVector[2]);

        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("c="+c);
    }