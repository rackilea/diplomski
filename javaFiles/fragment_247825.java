System.out.print("Please enter your photo's file type. It must be: JPG, GIF, PNG, BMP, or OTHER");
boolean typeInput = kb.nextLine();

inputMatches = true;
try{
    FileType fileType = FileType.valueOf(inputString.toUpperCase().trim());
}catch (IllegalArgumentException e) {
    inputMatches = false;
}