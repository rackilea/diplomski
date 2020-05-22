package odev3;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.util.*;



public class Odev3 {


    public static void main(String[] args) throws IOException {
    BufferedImage img=ImageIO.read(new File("xxx.jpg"));
    int [][] orijinal = new int[img.getHeight()][img.getWidth()];
            for (int i = 0; i <img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                orijinal[i][j]= img.getRGB(i,j);
                System.out.print(orijinal[i][j]+" ");
            }
                System.out.println();
        }


    int [][] anahtar = new int[256][256];
    Random rnd = new Random();//burda randam bir float sayi uretyoruz 

    float sayi = rnd.nextFloat();//  Random float sayiyi bir float degiskene aktaryoruz  
    System.out.println(sayi);

    int num = (int)(sayi * 1000);//float degiskenin 0 dan sonra uc sayiyi alyoruz
    for (int i = 0;i < 256; i++){
        for(int j = 0;j < 256;j++){
           anahtar[i][j] = num%255;
           System.out.print(anahtar[i][j]+" ");
        }
        System.out.println();
    }
    int [][] sifreli = new int[256][256];
    for (int i = 0; i < 256;i++){
        for(int j = 0;j < 256;j++){
            sifreli[i][j] = orijinal[i][j]^anahtar[i][j];
            System.out.print(sifreli[i][j] + " " );
           }
           System.out.println();
        }
    BufferedImage resim = new BufferedImage(256,256,BufferedImage.TYPE_INT_RGB);  
    for (int i = 0;i<256;i++)
        for(int j = 0;j < 256;j++)
        {
            resim.setRGB(i, j, sifreli[i][j]);
        }
    File outputfile = new File("sifreli.jpg");
    ImageIO.write(resim, "jpg", outputfile);
    }

}