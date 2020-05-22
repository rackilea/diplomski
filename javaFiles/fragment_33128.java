if (google_link != null && google_link.size() > 0) {
                        for (int j = 0; j < google_link.size(); j++) {
                            /*arrayTitle.add(google_link.get(j).getText().toString());
                            Log.e("array", arrayTitle.toString());*/

                            ExtraLinksObject links4 = new ExtraLinksObject();

                            String othergoogleTitle = google_tilte.get(j).getText().toString();//customtextTitle.getText().toString();
                            String othergooglelink = google_link.get(j).getText().toString();//customeditTextLink.getText().toString()
                            String googleId = extId.get(j).getText().toString();//eexId.getText().toString();
                            links4.setLink(othergooglelink);
                            links4.setTitle(othergoogleTitle);
                            links4.setExID(googleId);

                            extraLinks.add(links4);

                        }
                    }