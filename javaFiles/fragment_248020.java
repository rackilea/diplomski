int ch = 0;
int credits = 0;
final int baseCredits = Integer.parseInt(array4[4]);
String grade = array4[3];
switch (grade) {
    case "A":
        credits = baseCredits * 4;
        break;
    case "B":
        credits = baseCredits * 3;
        break;
    // etc.
}

int cGPA = baseCredits / credits;