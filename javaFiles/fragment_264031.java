while (!Arrays.equals (mix_team, orig_team)) {
    System.out.println("enter the index");
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    int y = scn.nextInt();
    char first=mix_team[x];
    char second=mix_team[y];
    mix_team[x]=second;
    mix_team[y]=first;
    for (int i = 0; i < mix_team.length; i = i + 1) 
    {
        System.out.print(i);  
        System.out.print(" ");
    }
    System.out.println();
    System.out.println(mix_team);
}
System.out.println("congratulations! you did it");
System.exit(0);