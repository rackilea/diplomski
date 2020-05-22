protected static Image createImage() {
            String path="bulb.gif";
            String description="";
            String imageURL = path;
            if (imageURL == null) {
                System.err.println("Resource not found: " + path);
                return null;
            } else {
                return (new ImageIcon(imageURL, description)).getImage();
            }
        }