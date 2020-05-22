public static void main(String[] args) {
        upperHalf(4);
        bottomHalf(4);
    }

    private static void upperHalf(int size) {
        for(int row = 0; row<size; row++){
            String rowContent = "";
            for(int col=0; col<size-row; col++){
                rowContent+= " *";
            }
            if(!rowContent.equals(""))
                System.out.println(rowContent);
        }
    }

    private static void bottomHalf(int size) {
        for(int row=2; row<=size; row++) {
            String rowContent = "";
            for(int col=0; col<row;col++) 
            {
                rowContent+= " *";
            }
            System.out.println(rowContent);
        }
    }