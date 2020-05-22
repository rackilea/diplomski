public class Test {
    public static void main (String [] args) {

        final int programUsersLength = 3;

        long [] [] programUserID = new long [programUsersLength][2];
        for (int i = 0; i < programUsersLength; i++) {
            programUserID[i][0] = 1998;
            programUserID[i][1] = 666;
        }

        for (int x = 0; x < programUserID.length; x++) {
            for (int y = 0; y < programUserID[x].length; y++) {
                System.out.print(programUserID[x][y]);
            }
            System.out.println();
        }
    }
}