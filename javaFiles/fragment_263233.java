Robo[] mass = new Robo[N];
for(int i = 0; i < mass.length; i++) {
    mass[i]= new Robo(); // Add this line
    mass[i].mainN = scan.nextInt();
    mass[i].auxiliary = scan.nextInt();
}