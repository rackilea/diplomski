HashMap<Integer, Character> hmap = new HashMap<Integer, Character>();
hmap.put(0, 'D');
hmap.put(1, 'G');
hmap.put(2, 'B');
hmap.put(3, 'Q');
hmap.put(4, 'P');
hmap.put(5, 'M');
hmap.put(6, 'R');
hmap.put(7, 'Y');
hmap.put(8, 'Z');
hmap.put(9, 'I');

Iterator<Integer> keySetIterator = hmap.keySet().iterator();
while(keySetIterator.hasNext()){
int key=keySetIterator.next();


System.out.println("key:" + key +  " value: "  +hmap.get(key));

}
for(int j=1001;j<9999;j++);
Random random=new Random();
int res=random.nextInt(100);
System.out.println(res);
String s = "";
s = String.valueOf(res);
String result="";

for(int i=0;i<s.length();i++)
{
    result+=hmap.get(Integer.valueOf(String.valueOf(s.charAt(i))));
}

System.out.println(result);
        }