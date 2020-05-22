jsize num_bytes = (*env)->GetArrayLength(env, array);
    char * buffer;

    buffer = (char *) malloc (num_bytes);

    jbyte  *lib = (*env)->GetByteArrayElements(env , array, 0);

    memcpy ( buffer , lib , num_bytes ) ;

    FILE *fp;
    fp=fopen("test.png", "wb");
    fwrite(buffer, sizeof(char) , num_bytes , fp);