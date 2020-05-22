protected String[] getAllNombres( ArrayList<Post> posts ) {
    String[] nombres = new String[ posts.size ];
    int i = 0;
    for( Post post : posts ) {
        nombres[i++] = post.getNombre();
    }
    return nombres;
}