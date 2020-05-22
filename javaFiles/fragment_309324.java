public Path resize(Path original) {
    return original.resolveSibling(original.getFileName().toString()
            //               v--- baseName 
            .replaceFirst("(.*?)(\\.[^.]+)?$", "$1_resized$2"));
            //                      ^--- extension            
}