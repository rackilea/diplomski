@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    try {
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                && null != data) {

            Uri selectedImage = data.getData();

            // Here you pass image path
            yourAdapter.add(selectedImage.toString());


            Toast.makeText(getActivity(), "Yor are picked image from" + selectedImage, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getActivity(), "You haven't picked image.",
                    Toast.LENGTH_LONG).show();
        }
    } catch (Exception e) {
        Toast.makeText(getActivity(), "Something went wrong.", Toast.LENGTH_LONG)
                .show();
    }
}