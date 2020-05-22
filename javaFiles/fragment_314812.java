String value = sc.next();
String[] tokens = value.split(",");
int[] values = new int[2];

values[0] = Integer.parseInt(tokens[0])
values[1] = Integer.parseInt(tokens[1])
if(values[0]>0 && values[1]>0)
    System.out.println("(" + values[0] + "," + values[1] + ")");