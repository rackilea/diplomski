private void saveNewUserGoogle(GoogleSignInAccount acct) {
        google = true;
        final ParseUser user = new ParseUser();
        String mFullName = acct.getDisplayName();
        String mEmail = acct.getEmail();
        String mProfilePic = String.valueOf(acct.getPhotoUrl());
        String mUsername = acct.getId();
        String password = acct.getId();
        user.setUsername(mUsername);
        user.setEmail(mEmail);
        user.setPassword(password);
        user.put("userEmail", mEmail);
        user.put("uniqueID", mUsername);
        user.put("name", mFullName);
        user.put("loginMethod", "Google");
        user.put("profilePicture", mProfilePic);
        user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        Log.e("SaveTest", "Successful");
                        //sign user up
                    } else {
                        switch (e.getCode()) {
                            case ParseException.USERNAME_TAKEN:
                                Toast.makeText(context, "Sorry, this username has already been taken.", Toast.LENGTH_SHORT).show();
                                break;
                            case ParseException.USERNAME_MISSING:
                                Toast.makeText(context, "Sorry, a username is needed", Toast.LENGTH_SHORT).show();
                                break;
                            case ParseException.PASSWORD_MISSING:
                                Toast.makeText(context, "Sorry, a password is needed.", Toast.LENGTH_SHORT).show();
                                break;
                            case ParseException.OBJECT_NOT_FOUND:
                                Toast.makeText(context, "invalid credentials", Toast.LENGTH_SHORT).show();
                                break;
                            case ParseException.CONNECTION_FAILED:
                                Toast.makeText(context, "Sorry, internet is needed.", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Log.d("Testing", e.getLocalizedMessage());
                                break;
                        }
                    }
                }
            });

    }