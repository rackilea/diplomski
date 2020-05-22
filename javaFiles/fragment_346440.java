public static void main(String[] args) {

    // random value between -35 and 40
    double celsius = Math.round(Math.random()*(40-35)-35);

    final String s = "     ______________________"
                        +"\r\n     |   ^F     _    ^C   |"
                        +"\r\n     |  100  - |{0}| -  40  |"
                        +"\r\n     |   90  - |{1}| -  30  |"
                        +"\r\n     |   80  - |{2}| -  25  |"
                        +"\r\n     |   70  - |{3}| -  20  |"
                        +"\r\n     |   60  - |{4}| -  15  |"
                        +"\r\n     |   50  - |{5}| -  10  |"
                        +"\r\n     |   40  - |{6}| -   5  |"
                        +"\r\n     |   30  - |{7}| -   0  |"
                        +"\r\n     |   20  - |{8}| -  -5  |"
                        +"\r\n     |   10  - |{9}| - -10  |"
                        +"\r\n     |    0  - |{10}| - -20  |"
                        +"\r\n     |  -10  - |{11}| - -25  |"
                        +"\r\n     |  -20  - |{12}| - -30  |"
                        +"\r\n     |  -30  - |{13}| - -35  |"
                        +"\r\n     |         '***`       |"
                        +"\r\n     |       (*****)      |"
                        +"\r\n     |        `---'        |"
                        +"\r\n     |____________________|"
                        ;

    final int [] celsiusDegreeCompare = new int[] {
        35,30,25,20,15,10,5,0
        ,-5,-10,-20,-25,-30,-35
    };

    final String[] parameters = new String[14];

    IntStream.range(0, parameters.length)
    .forEach(
        i -> {
            parameters[i] = (celsius >= celsiusDegreeCompare[i])? "*":" ";
        }
    )
    ;

    // ASCII Thermometer
    String meter = MessageFormat.format(s, parameters);

    System.out.println("celsius: " + celsius);
    System.out.println(meter);
}