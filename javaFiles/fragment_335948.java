@Override
                protected Map<String, DataPart> getByteData() {
                    Map<String, DataPart> params = new HashMap<>();
                    /// photo field in link
                    if (mVideoURI != null) {
                        params.put("video", new DataPart("file_avatar.mp4", UploadHelper.getFileDataFromDrawable(getActivity(), mVideoURI)));
                    }
                    return params;
                }