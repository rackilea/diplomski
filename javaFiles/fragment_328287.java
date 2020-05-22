JNIEXPORT void JNICALL Java_com_example_photoprocessing_activity_SurfaceProcessingActivity_showJPG(
        JNIEnv * env, jobject activity, jobject surface, jstring img) {
    const char * imgChar;
    jboolean * isCopy;
    imgChar = env->GetStringUTFChars(img, 0);
    ANativeWindow_Buffer nwBuffer;

    LOGI("img path : %s  ",imgChar);

    LOGI("ANativeWindow_fromSurface ");
    ANativeWindow * mANativeWindow = ANativeWindow_fromSurface(env, surface);

    if (mANativeWindow == NULL) {
        LOGE("ANativeWindow_fromSurface error");
        return;
    }

    LOGI("ANativeWindow_lock ");
    if (0 != ANativeWindow_lock(mANativeWindow, &nwBuffer, 0)) {
        LOGE("ANativeWindow_lock error");
        return;
    }

    read_jpeg_file_show(imgChar, nwBuffer);

    if (nwBuffer.format == WINDOW_FORMAT_RGBA_8888) {
        LOGI("nwBuffer->format == WINDOW_FORMAT_RGBA_8888 ");
    }

    LOGI("ANativeWindow_unlockAndPost ");
    if (0 != ANativeWindow_unlockAndPost(mANativeWindow)) {
        LOGE("ANativeWindow_unlockAndPost error");
        return;
    }

    env->ReleaseStringUTFChars(img,imgChar);
    ANativeWindow_release(mANativeWindow);
    LOGI("ANativeWindow_release ");
    return;
}

int read_jpeg_file_show(const char *input_filename,
        ANativeWindow_Buffer& nwBuffer) {
    struct jpeg_decompress_struct cinfo;
    struct jpeg_error_mgr jerr;
    FILE *input_file;
    JSAMPARRAY buffer;
    int row_width;

    unsigned char *buffertmp;

    cinfo.err = jpeg_std_error(&jerr);

    if ((input_file = fopen(input_filename, "rb")) == NULL) {
        fprintf(stderr, "can't open %s\n", input_filename);
        LOGI("can't open jpg1");
        return -1;
    }
    jpeg_create_decompress(&cinfo);

    /* Specify data source for decompression */
    jpeg_stdio_src(&cinfo, input_file);


    /* Read file header, set default decompression parameters */
    (void) jpeg_read_header(&cinfo, TRUE);


    /* Start decompressor */
    (void) jpeg_start_decompress(&cinfo);


    row_width = cinfo.output_width * cinfo.output_components;

    buffer = (*cinfo.mem->alloc_sarray)((j_common_ptr) &cinfo, JPOOL_IMAGE,
            row_width, 1);

    buffertmp = (unsigned char *) malloc(row_width);
    memset(buffertmp, 0, row_width);
    LOGI("malloc and memset");

    /* Process data */
    int get8h5 = 248, get8h6 = 252;
    __uint16_t * line = (__uint16_t *) nwBuffer.bits;
    int wheight = 0;

    int scalew = 1, scaleh = 1;

    if (cinfo.output_width > nwBuffer.width) {
        scalew = cinfo.output_width / nwBuffer.width;
    }

    LOGI(" scale of img = %d", scalew);

    for (int i = 0, choosehNum = 0; i < cinfo.output_height; i++) {

        jpeg_read_scanlines(&cinfo, buffer, 1);
        buffertmp = *buffer;

        if (i % scalew == 0 && choosehNum++ < nwBuffer.height) {

            //LOGI("nwBuffer->format == WINDOW_FORMAT_RGB_565");
            for (int j = 0, choosewNum = 0; j < cinfo.output_width; j++) {
                if (j % scalew == 0) {
                    if (nwBuffer.format == WINDOW_FORMAT_RGB_565) {
                        line[choosewNum] = ((__uint16_t ) buffertmp[3 * j + 0]
                                & get8h5) << 8
                                | ((__uint16_t ) (buffertmp[3 * j + 1] & get8h6)
                                        << 3)
                                | ((__uint16_t ) (buffertmp[3 * j + 2] & get8h6)
                                        >> 3);
                        choosewNum++;
                    }
                }

            }
            line = line + nwBuffer.stride;
        }
    }

    (void) jpeg_finish_decompress(&cinfo);
    LOGI("jpeg_finish_decompress !!");

    jpeg_destroy_decompress(&cinfo);
    LOGI("jpeg_destroy_decompress !!");

    /* Close files, if we opened them */
    fclose(input_file);

    return 0;
}