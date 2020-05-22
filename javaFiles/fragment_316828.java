public onActivityResult(int request, int result, Intent data) {

    if( request == CAPTURE_IMAGE ) {

        if( result == RESULT_OK ) {

            /*Use the image in the way you want to here and save the path */

            //Delete the image
            File image = new File(path);
            image.delete();

        }

    }

}