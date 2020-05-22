String stud[] = { "enter name:", "enter age:", "enter gender:" };

System.out.print("Enter How Many Inputs: ");
int num1 = Integer.parseInt(in.readLine());
if (num1 <= stud.length) {
    for (int x = 0; x < num1; x++) {
        System.out.println(stud[x]);
        //read input from user
    }
}