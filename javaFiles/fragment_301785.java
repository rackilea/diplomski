tv_view.setOnClickListener {
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = photoURI
                                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                startActivity(intent)
                            }