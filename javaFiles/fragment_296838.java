public void readyTexture(String textureDir){
        if (!loadedTextures.containsKey(textureDir) || loadedTextures.get(textureDir) == null) {
            texture = lt.loadTexture(textureDir);
            loadedTextures.put(textureDir, texture);
        } else {
            texture = loadedTextures.get(textureDir);
        }

        textureDirString = textureDir;
        texture.bind();
        texLoaded = true;
        System.out.println("Loaded: " + textureDirString);
    }