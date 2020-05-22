public static void main (String [] arg) throws Exception {
    String path = "C:\\folder\\myfile.txt";
    Scanner sc =  new Scanner(Paths.get(path), StandardCharsets.UTF_8.name());
    double area = 0, a = 0;
    int x = sc.nextInt();
    Figura F[] = new Figura[x];
    sc.nextLine();
    for (int i = 0; i < x; i++) {
        char s = sc.next().charAt(0);
        switch (s) {
            case 'r':
                double b = sc.nextDouble();
                double al = sc.nextDouble();
                F[i] = new Rettangolo(b, al);
                a = F[i].getArea();
                break;
            case 'c':
                double raggio = sc.nextDouble();
                F[i] = new Cerchio(raggio);
                a = F[i].getArea();
                break;
            case 't':
                double lato1 = sc.nextDouble();
                double lato2 = sc.nextDouble();
                double lato3 = sc.nextDouble();
                F[i] = new Triangolo(lato1, lato2, lato3);
                a = F[i].getArea();
                break;
            case 'q':
                double l = sc.nextDouble();
                F[i] = new Quadrato(l);
                a = F[i].getArea();
                break;
        }
        area = area + a;
    } 
    System.out.println("La somma delle aree e': "+area);
}