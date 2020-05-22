double x = 25.001;
int i = (int) x;
System.out.println(x);//Input
if (x - i <= 0.01) {
    x = (int) x;
}
System.out.println(x);//Output