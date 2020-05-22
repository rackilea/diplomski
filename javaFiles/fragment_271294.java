public void on_create(final Context context, final Class aclass) {
            post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyTask task = new MyTask(stor_root, mProgress, editTextplace, post, ninfo, imageUri,
                            mstorage, mDatabase, context, aclass);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    else
                        task.execute();
                }
            });
        }