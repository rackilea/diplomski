// ffmpeg command sample: "-y -i inputPath -ss 00:00:02 -codec copy -t 00:00:06 outputPath"
    public String getSplitCommand(String inputFileUrl, String outputFileUrl,
                                       String start, String end) {
        if ((TextUtils.isEmpty(inputFileUrl) && (TextUtils.isEmpty(outputFileUrl)))) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-y ")
                .append("-i ")
                .append(inputFileUrl).append(" ")
                .append("-ss ")
                .append(start).append(" ")
                .append("-codec ")
                .append("copy ")
                .append("-t ")
                .append(end).append(" ")
                .append(outputFileUrl);
        return stringBuilder.toString();
    }

public void executeBinaryCommand(FFmpeg ffmpeg, ProgressDialog progressDialog, final String command) {
        if (!TextUtils.isEmpty(command)) {
            try {
                ffmpeg.execute(command, new ExecuteBinaryResponseHandler() {
                    @Override
                    public void onFailure(String response) {
                        progressDialog.setMessage(response);
                    }

                    @Override
                    public void onSuccess(String response) {
                        progressDialog.setMessage(response);

                    }

                    @Override
                    public void onProgress(String response) {
                        progressDialog.setMessage(response);
                    }

                    @Override
                    public void onStart() {
                        progressDialog.show();
                    }

                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();
                    }
                });
            } catch (FFmpegCommandAlreadyRunningException exception) {
                exception.printStackTrace();
            }
        }
    }