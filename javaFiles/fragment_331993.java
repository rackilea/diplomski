public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
st_text = data.getText().toString().trim();
        if (id == R.id.post) {
            if (TextUtils.isEmpty(st_text)){
                AlertDialog.Builder builder = new AlertDialog.Builder(CreatePostActivity.this,R.style.AlertDialog);
                String titleText = "Error \n  ";
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark));
                SpannableStringBuilder ssBuilder = new SpannableStringBuilder(titleText);
                ssBuilder.setSpan(
                        foregroundColorSpan,
                        0,
                        titleText.length(),
                        Spanned.SPAN_INCLUSIVE_INCLUSIVE
                );
                builder.setTitle(ssBuilder);
                builder.setCancelable(false);
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.setMessage("You can't create empty post");
                dialog.show();
                return false;
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(CreatePostActivity.this,R.style.AlertDialog);
                builder.setTitle("Success");
                builder.setMessage("Your post is successfully created.");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }