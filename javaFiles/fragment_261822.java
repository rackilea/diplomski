case R.id.navigation_dashboard:
                mTextMessage.setText(R.string.title_dashboard);
                Toast toastd = Toast.makeText(context , R.string.title_dashboard, Toast.LENGTH_LONG);
                toastd.show();
                loadCalFragment();
                return true;