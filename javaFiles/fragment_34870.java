private int a;
private int b;
private int c;

private int d;

private String e;
private String f;
private String g;
private String h;
private String i;

public TooManyParams() {
    super();
}

public TooManyParams(int intvalues[], String strvalues[]) {

    this.a = intvalues[0];
    this.b = intvalues[1];
    this.c = intvalues[2];
    this.d = intvalues[3];

    this.e= strvalues[0];
    this.f= strvalues[1];
    this.g= strvalues[2];
    this.h= strvalues[3];
    this.i= strvalues[4];

    System.out.println("too many params can be accumulated to a small set of params"+this.a+this.b+this.c+this.d+this.e+this.f+this.g+this.h+this.i);

 }

public static void main(String args[]){
    int intParams[]={1,2,3,4};
    String strParams[]={"a","b","c","d","e"};
    TooManyParams tmp=new TooManyParams(intParams,strParams);
}
}