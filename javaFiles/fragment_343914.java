public void takePicture(View view) {
    camera.takePicture(null, null, new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Intent intent = new Intent(context, AcceptNotAccept.class);
            intent.putExtra("picture", data);
            startActivity(intent);
        }
    }
}