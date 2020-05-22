IMOperation op = new IMOperation();
        op.addImage(sourceFile);
        op.gravity("center");
        op.thumbnail(width, height, '^');
        op.extent(width,height);
        op.addImage(destinationFile);