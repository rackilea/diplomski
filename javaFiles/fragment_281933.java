Map<Character, IntUnaryOperator> commands = new HashMap<>();
commands.put('h', number -> funtion1(number) );
commands.put('t', number -> funtion1(number) );

// Invoke some command
char cmd = 'h';
IntUnaryOperator result=  commands.get(cmd);