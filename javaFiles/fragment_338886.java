package arg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Serialization {
    private static final String FILE_NAME = "test.dat";
    private static ArrayList<Name> names;

    public static void main(String[] args) {
        Serialization s = new Serialization();
        s.start();
    }

    private void start() {
        loadFile();
        promptForName();
    }


    private void promptForName() {
        String input = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (!input.equals("Exit")) {
                System.out.println("Press 1 to enter new name.\r\nPress 2 to save.\r\nPress 3 to display.\r\nType Exit to exit.");
                input = br.readLine();
                if (input.equals("1")) {
                    System.out.println("Enter a name");
                    input = br.readLine();
                    Name n = new Name();                    
                    n.name = input;
                    names.add(n);
                }
                else if (input.equals("2")){
                    saveFile();
                }
                else if (input.equals("3")){
                    for (Name n : names) {
                        System.out.println(n.name);
                    }
                }               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }

    private void saveFile() {
        File f = new File(FILE_NAME);
        f.delete();
        try {
            f.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
            oos.writeObject(names);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFile() {
        File f = new File(FILE_NAME);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f)))
            {
                names = (ArrayList<Name>) ois.readObject();
            } catch (IOException e) {
                f.delete();
                e.printStackTrace();
            } catch (ClassNotFoundException e) {                
                e.printStackTrace();
                f.delete();
            }
        }
        else
        {
            names = new ArrayList<Name>();
        }
    }

    private static class Name implements Serializable {
        public String name;
    }

}