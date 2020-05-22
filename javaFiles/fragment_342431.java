@Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful())
        {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                    .setDisplayName(mName.getText().toString())
                    //.setPhotoUri(Uri.parse("https://avatarfiles.alphacoders.com/862/86285.jpg"))
                    .build();

            user.updateProfile(profileUpdate);

            Log.d(TAG, "onComplete: User Profile updated");
            Toast.makeText(getActivity(), "NAME IS UPDATED XD XD XD", Toast.LENGTH_SHORT).show();

        }
        } else {
            //Display what happens if you couldn't update the name
        }
        hideProgressDialog();
   });