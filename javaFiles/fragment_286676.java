public class ProfileFragment extends Fragment implements AvatarDownloaderTask.OnTaskCompleted{

    /* -stripped out code- */

    // Use this call in your activity or fragment that also implements the OnTaskCompleted interface
    private void loadAvatar(String avatarUrl) {
        new AvatarDownloaderTask(this).execute(avatarUrl);
    }

    @Override
    public void onTaskCompleted(Avatar avatar) {
        switch (avatar.getType()) {
            case TYPE_X:
                _avatarProgressBar.setVisibility(View.GONE);
                _avatarImageView.setVisibility(View.GONE);
                _avatarImageViewPlaceholder.setVisibility(View.VISIBLE);
                break;
            case TYPE_Y:
                // Just a helper class with a shared Picasso instance
                ImageHandler.sharedHandler(getContext()).bypassImageResizer(avatar.getUri(), _avatarImageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        _avatarProgressBar.setVisibility(View.GONE);
                        _avatarImageViewPlaceholder.setVisibility(View.GONE);
                        _avatarImageView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError() {
                        _avatarProgressBar.setVisibility(View.GONE);
                        _avatarImageView.setVisibility(View.GONE);
                        _avatarImageViewPlaceholder.setVisibility(View.VISIBLE);
                    }
                });
                break;
        }
    }
}