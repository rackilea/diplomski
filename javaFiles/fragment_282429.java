else {
                        mProgressDialog.dismiss();
                        Log.e("Status",isCancelled() + ", before cancel");
                        cancel(true);
                        Log.e("Status",isCancelled() + ", after cancel");
                        return "Something";
                    }