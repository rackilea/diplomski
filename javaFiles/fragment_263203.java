byte buf[] = new byte[2];
buf[1] = 3;
for (int i = 0; i < 9; i++) {
    int bshifted = buf[1]<<i;
    System.out.println("buf[1]<<"+i+" = " + Integer.toBinaryString(bshifted) +"(binary) = "+ bshifted + "(decimal)");
}