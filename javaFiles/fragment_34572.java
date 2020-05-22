String line = bf.readLine();
while(line != null) {
    // Add code to look at your line to figure out what kind of object it 
    // represents.   For example you could add a one character prefix to each 
    // line when you write it to specify which object it is ('U', 'A' or 'T').
    // Based on that, you can call a constructor of the appropriate object that
    // takes a String as input. Then let the constructor deal with parsing the
    // line for the object it represents. This way you don't end up with some
    // massive parsing routine.

    char code = line.charAt(0);
    if(code == 'T') {
        Task task = new Task();
        task.initFromString(line.sustring(1));
        ... Do something with your task
    }
    else if(code == ...) {
    }

    line = bf.readLine();    // Read the next line
}