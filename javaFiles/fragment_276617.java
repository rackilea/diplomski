int[] ara1 = new int[]{1,2,3,4,5};
char[] ara2 = new char[]{'a','b','c','d','e'};

int len = ara1.length < ara2.length? ara1.length:ara2.length;
String[] outAra = new String[len];
for(int i = 0; i < ara1.length && i < ara2.length; i++)
    outAra[i] = String.valueOf(ara1[i]) + ara2[i];