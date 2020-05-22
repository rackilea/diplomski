int roll;
do {
    roll = (int) (Math.random()*6 + 1);

    switch (roll) {
        case 1: // printf a 1
                break;
        case 2: // printf a 2
                break;
        case 3: // printf a 3
                break;
        case 4: // printf a 4
                break;
        case 5: // printf a 5
                break;
        case 6: System.out.printf("%1$c %1$c\n%1$c %1$c\n%1$c %1$c\n", character2);
                break;
    }
} while (roll != 6);