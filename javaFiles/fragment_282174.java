public class Main {
    public static void main(String[] args) {
        System.out.println(getNextColumn("A"));
        System.out.println(getNextColumn("Z"));
        System.out.println(getNextColumn("AA"));
        System.out.println(getNextColumn("AZ"));
        System.out.println(getNextColumn("ZA"));
        System.out.println(getNextColumn("ZZ"));
        System.out.println(getNextColumn("AAA"));
        System.out.println(getNextColumn("ABA"));
        System.out.println(getNextColumn("ABZ"));
        System.out.println(getNextColumn("ZZZ"));
    }

    static String getNextColumn(String column) {
        column = column.toUpperCase();
        StringBuilder sb = new StringBuilder();
        boolean allZ = true;
        for (int i = 0; i < column.length(); i++) {
            if (!(column.charAt(i) == 'Z')) {
                allZ = false;
                break;
            }
        }
        if (allZ) {
            for (int i = 0; i <= column.length(); i++) {
                sb.append('A');
            }
            return sb.toString();
        }
        boolean charAfterZ = false;
        int indexOfZ = 0;
        for (int i = 0; i < column.length() - 1; i++) {
            if (column.charAt(i) == 'Z') {
                charAfterZ = true;
                indexOfZ = i;
                break;
            }
        }
        if (charAfterZ) {
            sb.append(column.substring(0, indexOfZ + 1) + (char) (column.charAt(indexOfZ + 1) + 1));
            if (column.length() > indexOfZ + 2) {
                sb.append(column.substring(indexOfZ + 1));
            }
            return sb.toString();
        }

        char lastChar = column.charAt(column.length() - 1);

        if (lastChar == 'Z') {
            sb.append(column.substring(0, column.length() - 2) + (char) (column.charAt(column.length() - 2) + 1) + ""
                    + 'A');
        } else {
            if (column.length() > 1) {
                sb.append(column.substring(0, column.length() - 1) + ""
                        + (char) (column.charAt(column.length() - 1) + 1));
            } else {
                sb.append((char) (column.charAt(column.length() - 1) + 1));
            }
        }
        return sb.toString();
    }
}