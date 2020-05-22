public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n1 = sc.nextInt();
  int n2 = sc.nextInt();
  int m = sc.nextInt();
  LinkedList<Integer>[] g = new LinkedList[n1];
  for (int j = 0; j < n1; j++) {
    g[j] = new LinkedList<Integer>();
  }
  int i = 0;
  while(i != m){
    int v = sc.nextInt();
    int v2 = sc.nextInt();
    if(v>=1 && v<=n1) { 
        //v belongs in first set 
        g[v-1].add(v2-n1-1);
    }else if(v>=n1+1 && v<=n1+n2) { 
        //v belongs in the second set, v2 into the first
        g[v2-1].add(v-n1-1);
    }
    i++;
  }
  System.out.println(maxMatching(g, n2));
}