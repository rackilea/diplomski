runOnUiThread(new Thread(new Runnable() {
                public void run() {
                    la.addItems(new ArrayList<Film>());
                    la.notifyDataSetChanged();
                    la.addItems(films);
                    la.notifyDataSetChanged();
                }
            }));