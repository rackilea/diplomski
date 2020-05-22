listView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                        int position, long id) {
                        if (position == 0)
                       {
                    MediaPlayer sijecanj = MediaPlayer.create(Mjeseci.this, R.raw.section1_mjeseci_sijecanj);
                    sijecanj.start();
                }
                }
            });