// Check for error node in json
            if (success == 1) {
                String username = jObj.getString(TAG_USERNAME);
                String user_type= jObj.getString(TAG_USERTYPE);
                String id = jObj.getString(TAG_ID);

                Log.e("Successfully Login!", jObj.toString());

                Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                // menyimpan login ke session
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(session_status, true);
                editor.putString(TAG_ID, id);
                editor.putString(TAG_USERNAME, username);
                editor.commit();

                // Memanggil main activity
                if(user_type.equals("admin")){
                Intent intent = new Intent(Login.this, AdminActivity.class);
                intent.putExtra(TAG_ID, id);
                intent.putExtra(TAG_USERNAME, username);
                finish();
                startActivity(intent);
                }
                else{
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.putExtra(TAG_ID, id);
                intent.putExtra(TAG_USERNAME, username);
                finish();
                startActivity(intent);
               }
            } else {
                Toast.makeText(getApplicationContext(),
                        jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

            }