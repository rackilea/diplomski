interface Display {
    void display(String message);
}

class ConsoleDisplay implements Display {
    void display(String message) {
        System.out.println(message);
    }
}

class FileDisplay implements Display {
    FileOutputStream out;

    FileDisplay(String filename) {
        out = new FileOutputStream(filename);
    }

    void display(String message) {
        out.write(message.getBytes());
    }
}

class DoingStuff {
    public static void main(String[] args) {
        Display dispFile = new FileDisplay("logfile.log");
        display("42!", dispFile);

        Display dispConsole = new ConsoleDisplay();
        display("42!", dispConsole);
    }

    static void display(String message, Display disp) {
        disp.display(message);
    }
}