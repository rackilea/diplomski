try {
                        Mp3File song = new Mp3File(location,false);

                        if (song.hasId3v2Tag()){
                            ID3v2 oritag=song.getId3v2Tag();
                            byte[] image=oritag.getAlbumImage();
                            if(image!=null){
                                if (image.length > 10) {
                                    song = new Mp3File(location, true);
                                    oritag=song.getId3v2Tag();
                                    ID3v24Tag newtag = new ID3v24Tag();

                                    // copy metadata

                                    newtag.setArtist(oritag.getArtist());
                                    newtag.setArtistUrl(oritag.getArtistUrl());
                                    newtag.setOriginalArtist(oritag.getOriginalArtist());
                                    newtag.setArtistUrl(oritag.getArtistUrl());

                                    newtag.setAlbum(oritag.getAlbum());
                                    newtag.setAlbumArtist(oritag.getAlbumArtist());

                                    newtag.setAudiofileUrl(oritag.getAudiofileUrl());
                                    newtag.setAudioSourceUrl(oritag.getAudioSourceUrl());
                                    newtag.setUrl(oritag.getUrl());

                                    newtag.setGenre(oritag.getGenre());
                                    newtag.setGrouping(oritag.getGrouping());

                                    newtag.setTitle(oritag.getTitle());
                                    newtag.setTrack(oritag.getTrack());

                                    newtag.setPublisher(oritag.getPublisher());
                                    newtag.setPublisherUrl(oritag.getPublisherUrl());
                                    newtag.setCopyright(oritag.getCopyright());
                                    newtag.setCopyrightUrl(oritag.getCopyrightUrl());
                                    newtag.setComposer(oritag.getComposer());
                                    newtag.setCommercialUrl(oritag.getCommercialUrl());
                                    newtag.setComment(oritag.getComment());
                                    newtag.setYear(oritag.getYear());
                                    newtag.setKey(oritag.getKey());
                                    newtag.setRadiostationUrl(oritag.getRadiostationUrl());
                                    newtag.setPaymentUrl(oritag.getPaymentUrl());

                                    song.setId3v2Tag(newtag);


                                    try {
                                        song.save(location + "intermed");

                                        File from = new File(location + "intermed");
// if successfull then replace old file with new file
                                        if(from.exists()) {
                                            File file = new File(location);
                                            long sizeold = file.length();
                                            file.delete();
                                            File to = new File(location);
                                            long sizenew = from.length();
                                            from.renameTo(to);
                                            freedspace += sizeold - sizenew;
                                            }

                                    } catch (IOException | NotSupportedException e) {
                                        e.printStackTrace();

                                    }
                                }
                            }
                        }

                    } catch (IOException | UnsupportedTagException | InvalidDataException e) {
                        e.printStackTrace();
                    }