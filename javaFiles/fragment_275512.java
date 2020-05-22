runOnUiThread(new Runnable() {
                public void run() {
                    ActivityHome.this.scanning_following.setText(ActivityHome.this.mapB.size()
                            + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.toString()
                            + ActivityHome.this.getResources().getString(R.string.following).toString()
                            + " scanned");
                }
            });