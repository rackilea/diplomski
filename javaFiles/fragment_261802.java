public class SubjectDriver {
    public static void main(String[] args) {
        int subjectAmount;
        Subject a = new Subject();
        Scanner input = new Scanner(System.in);
        System.out
            .println("Please input the amount of subjects are you resposible  for ?( Maximum 4)");
        subjectAmount = Integer.parseInt(input.nextLine());

        a.subjectName = new String[subjectAmount];
        a.subjectCode = new String[subjectAmount];
        a.subjectFee = new Double[subjectAmount];

        for (int index = 0; index < subjectAmount; index++) {
            System.out.println("enter subject name: ");
            a.subjectName[index] = input.nextLine();;

            System.out.println("enter subject code: ");
            a.subjectCode[index] = input.nextLine();

            System.out.println("enter subject fee: ");
            a.subjectFee[index] = Double.parseDouble(input.nextLine());
        }

        System.out.println("Subject name: " + Arrays.asList(a.getSubjectName())
            + "\nSubject Code: " + Arrays.asList(a.getSubjectCode()) + "\nSubject fee: "
            + Arrays.asList(a.getSubjectFee()));
    }
}