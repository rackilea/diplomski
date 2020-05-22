static ArrayList<Point> sumofNum(int N){
    ArrayList<Point> result = new ArrayList<Point>();
    for(int a=1; a<N; a++){
            //a+b=N
            int b = N-a;
        System.out.println(a+","+b);
        int next =a+1;
        if(next==b | a==b)
           result.add(new Point(a,b));
        }   
    return result;
    }