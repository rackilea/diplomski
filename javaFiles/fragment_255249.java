public class MapTest {

    int[][] map = new int[100][4]; 

    {
        for(int i = 0; i < 101; i++) {
            map[i][1] = i;
            map[i][2] = i;
            map[i][3] = 1;
            map[i][4] = 0;
        }
    }

}