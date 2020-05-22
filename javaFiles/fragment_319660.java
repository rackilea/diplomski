Element layer = doc.createElement("layer");
        layer.setAttribute("name", "layer");
        layer.setAttribute("width", width);
        layer.setAttribute("height", height);



            Element data = doc.createElement("data");

            ByteArrayOutputStream os = new ByteArrayOutputStream();                
            for(int tileY = 0;tileY<layerHeight;tileY++){
                for(int tileX = 0;tileX<layerWidth;tileX++){
                    int tileGID = this.data[tileX][tileY];
                    os.write(tileGID);
                    os.write(tileGID << 8);
                    os.write(tileGID << 16);
                    os.write(tileGID << 24);
                }
            }
            os.flush();
            String compressedData = Base64.encodeBytes(os.toByteArray(),Base64.DONT_BREAK_LINES|Base64.GZIP|Base64.ENCODE);
            data.appendChild(doc.createTextNode(compressedData));               
            data.setAttribute("encoding", "base64");
            data.setAttribute("compression","gzip");

            layer.appendChild(data);

        mapElement.appendChild(layer);