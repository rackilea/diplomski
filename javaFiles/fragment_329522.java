public static final String PIECES_IMAGE_PATH = "Images/chess_pieces.png";
public static final int PIECE_IMAGES_INROW = 6;
public static final int PIECE_IMAGE_ROWS = 2;


public static void main(String args[]) {
    BufferedImage[][] pieceIcons = new BufferedImage[PIECE_IMAGES_INROW][PIECE_IMAGE_ROWS];

    try {
        BufferedImage image = ImageIO.read(new File(Try.class.getResource(PIECES_IMAGE_PATH).toURI()));

        int pieceImageWidth = image.getWidth()/PIECE_IMAGES_INROW;
        int pieceImageHeight = image.getHeight()/PIECE_IMAGE_ROWS;
        for(int x = 0; x < PIECE_IMAGES_INROW; x++){
            for(int y = 0; y < PIECE_IMAGE_ROWS; y++){
                try{
                    pieceIcons[x][y] = image.getSubimage(x*pieceImageWidth,y*pieceImageHeight,pieceImageWidth,pieceImageHeight);
                }catch(Exception e){
                    System.out.println("Error1: "+e.getMessage());
                }
            }
        }
    }catch(Exception e){
        System.out.println("error2: "+e.getMessage());
    }
}