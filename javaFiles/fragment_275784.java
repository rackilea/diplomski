scan.close();
scan = new Scanner(f);
for (int i = 0; i < 30; i++) {
    for (int j = 0; j < 6; j++) {
        subjects[i][j] = scan.nextInt();
    }
}