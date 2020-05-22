String input = "3 12#45#33 94#54#23 98#59#27";
String[] strings = input.split(" ");

int size = Integer.parseInt(strings[0]);
int[][] result = new int[size][size];

for( int i = 0; i < strings.length - 1; i++ ){
    String[] strings2 = strings[i + 1].split("#");
    for( int j = 0; j < strings2.length; j++ ){
        result[i][j] = Integer.parseInt(strings2[j]); // add the parsed int to result
    }
}