import static javax.swing.JOptionPane.*;
    String str = "";
    char tegn=' ';
    do {
     str = showInputDialog("Input a char.");
     if (str != null && !"".equalsIgnoreCase(str.trim()))
     {
       tegn = str.charAt(0);
     }
    }while(str!=null && !"".equalsIgnoreCase(str.trim())