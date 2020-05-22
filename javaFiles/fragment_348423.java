//  final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
final MediaType MEDIA_TYPE=MediaType.parse(AppConstant.arrImages.get(i).getMediaType());

//If you can have multiple file types, set it in ArrayList
                    MultipartBuilder buildernew = new MultipartBuilder().type(MultipartBuilder.FORM)
                            .addFormDataPart("title", title)

                    for (int i = 0; i < AppConstants.arrImages.size(); i++) {
                        File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                                TEMP_FILE_NAME + i + ".png");
                        if (f.exists()) {
                            buildernew.addFormDataPart(TEMP_FILE_NAME + i, TEMP_FILE_NAME + i + FILE_EXTENSION, RequestBody.create(MEDIA_TYPE, f));
                        }
                    }
                    RequestBody requestBody = buildernew.build();
                    Request request = new Request.Builder()
                            .url(Url.URL + Url.INSERT_NEWS)
                            .post(requestBody)
                            .build();

                    OkHttpClient client = new OkHttpClient();
                    Response response = client.newCall(request).execute();
                    return response.body().string();