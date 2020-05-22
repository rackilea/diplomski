Desktop desktop = Desktop.getDesktop();
try {
desktop.print(new File("file.xlsx"));
} catch (Exception e) {           
e.printStackTrace();
}
}