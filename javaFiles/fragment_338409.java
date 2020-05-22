String[] a = new String[ atoms.length/2 ];
int[] n = new int[ atoms.length/2 ];

for(int i = 0 ; i < a.length ; i++) {
    a[i] = atoms[i*2];
    n[i] = Integer.parseInt(atoms[i*2+1]);
}