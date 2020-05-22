case R.id.socialMediaShareButton:
          catLoadingView.show(getSupportFragmentManager(),"");
          //loadingDialog = LoadingDialog.Companion.get(SocialMediaActivity.this).show();
          uploadImageToServer(new MyCallback() {
              runOnUiThread {
                 catLoadingView.dismiss();
              }
          });
          break;