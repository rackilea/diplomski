int len = 3;
int num = (int)Math.pow(2, len);
for(int i=0; i<num; i++){
    // http://stackoverflow.com/a/4421438/1273830
    System.out.println(String.format("%"+len+"s", Integer.toBinaryString(i)).replace(' ', '0'));
}