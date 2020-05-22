String str = "Bob Jones: e100 e80 e90 q10 q10 q0 h10 h5 h10";
Pattern p = Pattern.compile("(\\D)(\\d+)");
String[] input = str.split("\\s*:\\s*"); // optional white space \\s*
System.out.println("Name: " + input[0]);
String[] grades = input[1].split("\\s+"); // one (or more) consecutive 
                                          // white space characters \\s+
int[] exams = new int[countChar(input[1], 'e')];
int[] quizs = new int[countChar(input[1], 'q')];
int[] homework = new int[countChar(input[1], 'h')];
int epos = 0, qpos = 0, hpos = 0;
for (String grade : grades) {
    Matcher m = p.matcher(grade);
    if (m.matches()) {
        String type = m.group(1);
        if (type.equals("e")) {
            exams[epos++] = Integer.parseInt(m.group(2));
        } else if (type.equals("q")) {
            quizs[qpos++] = Integer.parseInt(m.group(2));
        } else if (type.equals("h")) {
            homework[hpos++] = Integer.parseInt(m.group(2));
        }
    }
}
System.out.println("Homework: " + Arrays.toString(homework));
System.out.println("Quizs: " + Arrays.toString(quizs));
System.out.println("Exams: " + Arrays.toString(exams));