package com.game.task;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class imagesTest {

public LinkedList<Image> storeImages = new LinkedList<Image>();
private LinkedList<String> storeStrings = new LinkedList<String>();

public imagesTest() {
    load();
    start();
}

public void readimage(String f) {


    Image temp = new ImageIcon(this.getClass().getResource("/res/"+f)).getImage();//looks for it
    storeImages.add(temp);//put it in a linked-List(Image)

}

public void start(){
    for(int index = 0; index < storeStrings.size(); index++){
        readimage(storeStrings.get(index));//calling the methode to look in resource folder
    }
}
//reads the text file and puts the out put in a linked-list(String)
private void load() {
    File file = new File("Data/startUp.txt");
    try {
        Scanner read = new Scanner(file);
        while (read.hasNextLine()) {
            storeStrings.add(read.nextLine());
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}

public static void main(String[] arsg) {
    imagesTest t = new imagesTest();
}
}