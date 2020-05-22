String instr;
int val, maxval = 0;
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
while ((instr = input.readLine())!=null) { 
    val = Integer.parseInt(instr);
    if (val < 0 || val > 100) break;
    maxval = Math.max(maxval, val);
}
input.close();
System.out.println(maxval);