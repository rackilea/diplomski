BufferedReader f = new BufferedReader(new FileReader("shoppay.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shoppay.out")));
Queue<Integer> line = new LinkedList <Integer>();
int num = Integer.parseInt(f.readLine()); // not needed
String str;
List<List<Integer>> regs = new ArrayList<List<Integer>>(num);

for (int i = 0; i < num; ++i) {
    regs.add(new LinkedList<Integer>());
}

while ((str = f.readLine()) != null)
{
    if (str.charAt(0) == 'C')
        line.add(Integer.parseInt(str.split(" ")[1]));
    else
        regs.get(Integer.parseInt(str.split(" ")[1]) - 1).add(line.poll());
}