Scanner input = new Scanner(System.in);
Vector <Vector <String>> allValues = new Vector <Vector <String>>();
Vector <String> currentTestValues = new Vector <String>();
int tests = Integer.parseInt(input.nextLine());
for (int i = 0; i < tests; i++){
    int deposits = Integer.parseInt(input.nextLine());
    for (int j = 0; j < deposits; j++){
        String s = input.nextLine();
        currentTestValues.add(s);
    }
    allValues.add(currentTestValues);

}
for (Vector <String> v : allValues){
    for (String s : v){
        System.out.println(s);
    }
}
}