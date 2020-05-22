public void setTeamNames(int X) {
    for (int i = 0; i >= X; i++)
    {
        int Q = 0;
        String C;
        System.out.printf("Please Enter the %n Team Names ;\n",Q);
        C = input.nextLine();
        TeamNames.add(C);
        Q=1+Q;
    }
}