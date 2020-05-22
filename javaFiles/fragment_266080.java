public static String WriteArray()
{
    StringBuilder sb = new StringBuilder(); // Buffer to store the printed lines

    for (int i = 0; i < 2; i++) {
        for (String lines : ArrayColors()) {

            switch (i) {
            case 0:
                lines = lines.replace("Red", "Blood");
                break;
            case 1:
                lines = lines.replace("Blue", "Ocean");
                break;
            case 2:
                lines = lines.replace("Green", "Giant");
                break;
            }

            System.out.println(lines);
            sb.append(lines); // Store the printed line
        }
        System.out.println();
        sb.append("\n"); // Store a blank line
    }
    return sb.toString();
}