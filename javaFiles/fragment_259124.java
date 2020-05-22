switch (Progress) {
case "CloudQ":
    switch (yourChoice) {
    case "c1":
        Cloud = "HD";
        TempQuestion();
        break;
    case "c2":
        Cloud = "HB";
        TempQuestion();
        break;
    case "c3":
        Cloud = "LD";
        TempQuestion();
        break;
    case "c4":
        Cloud = "LB";
        TempQuestion();
        break;
    case "c5":
        Cloud = "Clear";
        TempQuestion();
        break;
    case "c6":
        Cloud = "Foggy";
        TempQuestion();
        break;
    }
    break; // Add this
case "TempQ":
    switch (yourChoice) {
    case "c1":
        Temp = 90110;
        HumQuestion();
        break;
    case "c2":
        Temp = 7089;
        HumQuestion();
        break;
    case "c3":
        Temp = 5069;
        HumQuestion();
        break;
    case "c4":
        Temp = 3049;
        HumQuestion();
        break;
    case "c5":
        Temp = 1029;
        HumQuestion();
        break;
    case "c6":
        Temp = 010;
        HumQuestion();
        break;
    }
    break; // Add this
}