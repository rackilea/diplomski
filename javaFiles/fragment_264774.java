if(selectedImagePath == null){
//Show error message

} else{
    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                    sharingIntent.setType("image/*");
                    sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(selectedImagePath));
                    startActivity(Intent.createChooser(sharingIntent, "Share Image Using"));
}